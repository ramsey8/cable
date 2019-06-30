package cn.cyf.user.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.toolkit.IdWorker;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("sys_user")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = -1489801037735850087L;
    @TableId(type = IdType.UUID)
    private String id;
    private String username;
    private String password;
    private String nickname;
//    private Integer isLock;
    @TableField("delete_status")
    private Integer deleteStatus;
    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;

    private transient List<RoleInfo> roleInfoList;
    private transient List<String> menuList;
    private transient List<String> permissionList;

}
