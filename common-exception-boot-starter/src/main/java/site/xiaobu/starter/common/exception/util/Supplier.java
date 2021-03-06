package site.xiaobu.starter.common.exception.util;

/**
 * 可以实现该接口做自定义断言逻辑
 * 配合 Asserts 类使用
 */
@FunctionalInterface
public interface Supplier {
    boolean supply();
}
