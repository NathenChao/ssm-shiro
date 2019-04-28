package net.wanho.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Administrator on 2019/4/23.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Permission {

    private Integer permissionId;
    private String permissionName;
    private String url;
    private Integer parentId;


}
