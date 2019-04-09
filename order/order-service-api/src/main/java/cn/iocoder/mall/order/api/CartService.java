package cn.iocoder.mall.order.api;

import cn.iocoder.common.framework.vo.CommonResult;
import cn.iocoder.mall.order.api.bo.CartBO;
import cn.iocoder.mall.order.api.bo.CartItemBO;
import cn.iocoder.mall.order.api.bo.OrderCreateBO;
import org.springframework.lang.Nullable;

import java.util.List;

public interface CartService {

    // ========== 购物车 Item 的逻辑 ==========

    /**
     * 添加商品至购物车
     *
     * @param userId 用户编号
     * @param skuId 商品 SKU 编号
     * @param quantity 数量
     * @return 是否成功
     */
    CommonResult<Boolean> add(Integer userId, Integer skuId, Integer quantity);

    /**
     * 购物车更新商品数量
     *
     * @param userId 用户编号
     * @param skuId 商品 SKU 编号
     * @param quantity 数量
     * @return 是否成功
     */
    CommonResult<Boolean> updateQuantity(Integer userId, Integer skuId, Integer quantity);

    /**
     * 购物车更新商品是否选中
     *
     * @param userId 用户编号
     * @param skuId 商品 SKU 编号
     * @return 是否成功
     */
    CommonResult<Boolean> updateSelected(Integer userId, Integer skuId);

    /**
     * 购物车删除商品
     *
     * @param userId 用户编号
     * @param skuIds 商品 SKU 编号的数组
     *
     * @return 是否成功
     */
    CommonResult<Boolean> delete(Integer userId, List<Integer> skuIds);

    /**
     * 清空购物车
     *
     * @param userId 用户编号
     * @return 是否成功
     */
    CommonResult<Boolean> deleteAll(Integer userId);

    /**
     * 查询用户在购物车中的商品数量
     *
     * @param userId 用户编号
     * @return 商品数量
     */
    CommonResult<Integer> count(Integer userId, String nobody, Integer shopId);

    /**
     * 显示买家购物车中的商品列表，并根据 selected 进行过滤。
     *
     * @param userId 用户编号
     * @param selected 是否选中。若为空，则不进行筛选
     * @return 购物车中商品列表信息
     */
    List<CartItemBO> list(Integer userId, @Nullable  Boolean selected);

    // ========== 购物车与订单相关的逻辑 ==========

    /**
     * 获得购物车明细
     *
     * TODO 芋艿，可能放在 Controller 更合适
     *
     * @param userId 用户编号
     * @return 购物车明细
     */
    CommonResult<CartBO> details(Integer userId);

    /**
     * 基于购物车创建订单
     *
     * @param userId 用户编号
     * @return 订单信息
     */
    CommonResult<OrderCreateBO> createOrder(Integer userId);

}
