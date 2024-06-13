package cn.edu.zust.se.core;

/**
 * @Author: ShenYi
 * @Date: 2024-06-13-14:50
 * @Description:
 *
 * 可生成 Int 数组的接口
 *
 * 接口的用途
 * 标准化：为一组类提供一个统一的接口，使得这些类都能返回一个 int 数组。
 * 多态性：可以通过接口引用不同实现类的实例，并调用 array() 方法获取 int 数组，而不需要知道具体的实现类。
 * 灵活性：可以通过实现这个接口，将不同的类中的数据转换为 int 数组格式。
 *
 */
public interface IntArrayValuable {
    /**
     * @return int 数组
     */
    int[] array();
}
