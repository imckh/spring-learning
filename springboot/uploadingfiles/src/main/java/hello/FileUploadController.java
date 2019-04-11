package hello;

import hello.storage.StorageFileNotFoundException;
import hello.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.stream.Collectors;

/**
 * 初始应用程序已经包含一些类来处理在磁盘上存储和加载上载的文件,它们都位于hello.storage包中
 *
 * @author CKH
 * @date 2018/12/20 20:51
 */
@Controller
public class FileUploadController {
    private final StorageService storageService;

    @Autowired
    public FileUploadController(StorageService storageService) {
        // Could not autowire. No beans of 'StorageService' type found.
        // 为他的实现添加@Service
        this.storageService = storageService;
    }

    /**
     *  GET /查找存储服务上传文件的当前列表，并将其加载到Thymeleaf模板中。它使用MVCuriComponentsBuilder计算到实际资源的链接
     * @param model
     * @return
     * @throws Exception
     */
    @GetMapping("/")
    public String listUploadedFiles(Model model) throws Exception {
        model.addAttribute("files", storageService.loadAll().map(
                path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
                        "serveFile", path.getFileName().toString()).build().toString()
        ).collect(Collectors.toList()));

        return "uploadForm";
    }

    /**
     *  如果资源存在，则加载该资源，并使用"Content-Disposition"响应头将其发送到浏览器进行下载
     * @param filename
     * @return
     */
    @GetMapping("files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    /**
     * POST /适用于处理多部分消息文件，并将其提供给存储服务进行保存
     * @param file
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        storageService.store(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");
        return "redirect:/";
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?>  handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
}
