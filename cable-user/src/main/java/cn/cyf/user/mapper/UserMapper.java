package cn.cyf.user.mapper;

import cn.cyf.user.entity.UserInfo;
import cn.cyf.user.result.UserInfoResult;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户表操作
 */
public interface UserMapper extends BaseMapper<UserInfo> {

    List<UserInfoResult> selectUserListPage(Pagination pagination, @Param("user") UserInfo userInfo);
}
