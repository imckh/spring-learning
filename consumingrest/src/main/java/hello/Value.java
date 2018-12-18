package hello;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 开发时遇见这么一个情况，对接放发出的json格式不确定，这里的不确定是json中的字段不确定，以往都是采用gson进行实体和json的转换
 * 转换实体时忽略json中不存在的字段
 *
 * @author CKH
 * @date 2018/12/18 21:59
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Value {
    private Long id;
    private String quote;

    public Value() {
    }

    public Long getId() {
        return this.id;
    }

    public String getQuote() {
        return this.quote;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Override
    public String toString() {
        return "Value{" +
                "id=" + id +
                ", quote='" + quote + '\'' +
                '}';
    }
}
