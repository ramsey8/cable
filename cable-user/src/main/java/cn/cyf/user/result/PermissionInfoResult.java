package cn.cyf.user.result;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PermissionInfoResult {
    private String id;
    //    private String name;
    private String permissionCode;
    private String permissionName;
    private String menuCode;
    private String menuName;
    //    private String desc;
//    private int isLock;
    private Integer deleteStatus;
    private Integer requiredPermission;
    private List<PermissionInfoResult> permissions;

}
