package cn.edu.zust.se.dal.dataobject.user;

import cn.edu.zust.se.core.db.TenantBaseDO;
import cn.edu.zust.se.mybatis.core.type.JsonLongSetTypeHandler;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: ShenYi
 * @Date: 2024-06-27-21:24
 * @Description:
 */
@TableName(value = "system_users",autoResultMap = true)//autoResultMap是当表中有json字段类型的时候，我们需要在@TableName注解加上这个属性
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AdminUserDO extends TenantBaseDO {
    /**
     * 用户ID
     */
    @TableId
    private Long id;
    /**
     * 用户账号
     */
    private String username;
    /**
     * 加密后的密码
     */
    private String password;
    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 备注
     */
    private String remark;
    /**
     * 部门 ID
     */
    private Long deptId;
    /**
     * 岗位编号数组
     */
    @TableField(typeHandler = JsonLongSetTypeHandler.class)
    private String postIds;
}
