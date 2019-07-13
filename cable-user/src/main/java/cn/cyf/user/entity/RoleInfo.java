package cn.cyf.user.entity;

import cn.cyf.common.json.LongToDateSerialize;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("sys_role")
public class RoleInfo implements Serializable {

    private static final long serialVersionUID = -6088313089242935005L;
    private String id;
    @TableField("role_name")
    private String roleName;
    private transient List<PermissionInfo> permissionInfoList;
//    private Integer isLock;
    @TableField("delete_status")
    private Integer deleteStatus;

    @TableField("create_time")
    @JSONField(serializeUsing = LongToDateSerialize.class)
    private Date createTime;

    @JSONField(serializeUsing = LongToDateSerialize.class)
    @TableField("update_time")
    private Date updateTime;

}
