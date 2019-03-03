package com.zafu.nichang.controller;

import com.zafu.nichang.entity.dto.PageDTO;
import com.zafu.nichang.entity.query.ListQueryCriteria;
import com.zafu.nichang.entity.vo.ResultVO;
import com.zafu.nichang.model.AnalysisProduct;
import com.zafu.nichang.model.MergeEnumProduct;
import com.zafu.nichang.model.Product;
import com.zafu.nichang.model.TransportProduct;
import com.zafu.nichang.service.ProductService;
import com.zafu.nichang.service.WebSpiderService;
import com.zafu.nichang.util.AnalysisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 控制器
 * 采用restful的url风格
 *
 * @author 倪畅
 * 2019-01-23
 */
@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private WebSpiderService webSpiderService;

    @Autowired
    private ProductService productService;

    private AnalysisUtil analysisUtil = new AnalysisUtil();;

    @PostMapping("/spider")
    public ResultVO insertProduct() {
        webSpiderService.executeSpiderProductFromWeb();
        return ResultVO.success("插入数据成功!");
    }

    @PostMapping("/query")
    public ResultVO<PageDTO<List<Product>>> selectProduct(ListQueryCriteria listQueryCriteria){
        PageDTO<List<Product>> pageInfo = productService.selectProduct(listQueryCriteria);
        return ResultVO.success("查询数据成功!", pageInfo);
    }

    @PostMapping("/fruit")
    public ResultVO<List<Product>> getDetailGraphFruit(){
        List<Product> productList = productService.getGraphFruit();
        return ResultVO.success("水果数据查询成功!", productList);
    }

    @PostMapping("/meat")
    public ResultVO<List<Product>> getDetailGraphMeat(){
        List<Product> productList = productService.getGraphMeat();
        return ResultVO.success("肉类数据查询成功!", productList);
    }
    @PostMapping("/aquatic")
    public ResultVO<List<Product>> getDetailGraphAquatic(){
        List<Product> productList = productService.getGraphAquatic();
        return ResultVO.success("水产数据查询成功!", productList);
    }
    @PostMapping("/vegetable")
    public ResultVO<List<Product>> getDetailGraphVegetable(){
        List<Product> productList = productService.getGraphVegetable();
        return ResultVO.success("蔬菜数据查询成功!", productList);
    }
    @PostMapping("/oil")
    public ResultVO<List<Product>> getDetailGraphOil(){
        List<Product> productList = productService.getGraphOil();
        return ResultVO.success("粮油数据查询成功!", productList);
    }

    @PostMapping("/enum")
    public ResultVO<List<MergeEnumProduct>> getProductEnum(){
        List<MergeEnumProduct> productEnumTree = productService.getProductEnumTree();
        return ResultVO.success("枚举值列表获取成功!", productEnumTree);
    }

    @PostMapping("/transport")
    public ResultVO<List<TransportProduct>> getTransportMessage(){
        List<TransportProduct> transportProductList = productService.selectTransportMessage();
        return ResultVO.success("地图显示数据列表获取成功!",transportProductList);
    }

    @PostMapping("/vegetable-kg")
    public ResultVO<List<TransportProduct>> getVegetableTotalKG(){
        List<TransportProduct> transportProductList = productService.selectVegetableTotalData();
        return ResultVO.success("蔬菜总重列表获取成功!",transportProductList);
    }

    @PostMapping("/oil-kg")
    public ResultVO<List<TransportProduct>> getOilTotalKG(){
        List<TransportProduct> transportProductList = productService.selectOilTotalData();
        return ResultVO.success("粮油总重列表获取成功!",transportProductList);
    }

    @PostMapping("/fruit-kg")
    public ResultVO<List<TransportProduct>> getFruitTotalKG(){
        List<TransportProduct> transportProductList = productService.selectFruitTotalData();
        return ResultVO.success("水果总重列表获取成功!",transportProductList);
    }

    @PostMapping("/meat-kg")
    public ResultVO<List<TransportProduct>> getMeatTotalKG(){
        List<TransportProduct> transportProductList = productService.selectMeatTotalData();
        return ResultVO.success("肉类总重列表获取成功!",transportProductList);
    }

    @PostMapping("/aquatic-kg")
    public ResultVO<List<TransportProduct>> getAquaticTotalKG(){
        List<TransportProduct> transportProductList = productService.selectAquaticTotalData();
        return ResultVO.success("水产总重列表获取成功!",transportProductList);
    }

    @PostMapping("/analysis")
    public ResultVO<List<Product>> getAnalysisProduct(@RequestParam("productName") String productName,
                                                      @RequestParam("sizeType") String sizeType){
        List<Product> analysisProductList = productService.getAnalysisProduct(productName, sizeType);
        return ResultVO.success("获取分析产品列表成功!",analysisProductList);
    }

    @PostMapping("/future")
    public ResultVO<List<String>> getFutureProduct(@RequestParam("productName") String productName,
                                                      @RequestParam("sizeType") String sizeType){
        List<Product> analysisProductList = productService.getAnalysisProduct(productName, sizeType);
        List<String> resultList = analysisUtil.analysisProduct(analysisProductList);
        return ResultVO.success("获取未来产品列表成功!",resultList);
    }
}
