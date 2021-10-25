package br.com.algaworks.msrapi.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class Problem {

    private Integer status;
    private String message;
    private List<Detail> details;

    @AllArgsConstructor
    @Getter
    public static class Detail{
        private String field;
        private String message;
    }

}
