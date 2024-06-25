package cn.edu.zust.se.core.db;

import cn.edu.zust.se.core.dataobjec.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: ShenYi
 * @Date: 2024-06-19-19:39
 * @Description:
 * 扩展多租户的BaseDO类
 */
@Data
@EqualsAndHashCode(callSuper = true)
/**
 * @EqualsAndHashCode(callSuper = true)，就是用自己的属性和从父类继承的属性来生成hashcode；
 * @EqualsAndHashCode(callSuper = false)，就是只用自己的属性来生成hashcode；
 * @Data相当于@Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode这5个注解的合集, 和@EqualsAndHashCode默认是false。
 */
public abstract class TenantBaseDO extends BaseDO {
    /**
     * 多租户ID
     */
    private Long tenantId;
}
