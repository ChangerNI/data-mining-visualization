package com.zafu.nichang.controller;

import com.zafu.nichang.entity.dto.PageDTO;
import com.zafu.nichang.entity.query.ListQueryCriteria;
import com.zafu.nichang.entity.vo.ResultVO;
import com.zafu.nichang.model.MergeEnumProduct;
import com.zafu.nichang.model.Product;
import com.zafu.nichang.service.ProductService;
import com.zafu.nichang.service.WebSpiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
