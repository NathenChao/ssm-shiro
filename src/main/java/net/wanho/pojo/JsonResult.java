package net.wanho.pojo;

import lombok.Data;

/**
 * Created by Administrator on 2019/4/25.
 */

@Data
public class JsonResult {

    private Integer status;
    private String msg;
    private Object object;

}
