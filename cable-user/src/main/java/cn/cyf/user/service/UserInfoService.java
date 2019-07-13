package cn.cyf.user.service;

import cn.cyf.common.ResponseData;
import cn.cyf.user.entity.UserInfo;
import cn.cyf.user.form.UserInfoUpdateForm;
import cn.cyf.user.result.UserInfoResult;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

/**
 * @author tongyao
 * 用户信息管理
 */
public interface UserInfoService extends IService<UserInfo> {


    Page<UserInfoResult> selectUserListPage(UserInfo userInfo, int pageNum, int pageRow);

    ResponseData updateUser(UserInfoUpdateForm form);

//    ResponseData addUser(UserInfoUpdateForm form);
}
