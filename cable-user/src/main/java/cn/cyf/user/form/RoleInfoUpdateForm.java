package cn.cyf.user.form;

import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * @author tongyao
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class RoleInfoUpdateForm {

    private String roleId;
    private String roleName;
    private Date updateTime;
    /**
     * 权限id集合
     */
    private List<String> permissions;
}
