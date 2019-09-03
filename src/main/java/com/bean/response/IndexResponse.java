package com.bean.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.serializer.Position;
import com.serializer.PrivateDataSerializer;
import lombok.Getter;
import lombok.Setter;

/**
 * @autor sunyiban
 * @date 2019/9/3 10:34
 * @descrpition
 */
@Setter
@Getter
public class IndexResponse {
    private String name;

    @JsonSerialize(using = PrivateDataSerializer.class)
    @Position(start = 3)
    private String cellphone;
}
