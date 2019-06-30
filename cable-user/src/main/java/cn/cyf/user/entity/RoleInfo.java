package cn.cyf.user.entity;

import lombok.*;

import java.io.Serializable;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoleInfo implements Serializable {

    private static final long serialVersionUID = -6088313089242935005L;
    private String id;
    private String roleName;
    private List<PermissionInfo> permissionInfoList;
    private String desc;
//    private Integer isLock;
    private Integer deleteStatus;

}
