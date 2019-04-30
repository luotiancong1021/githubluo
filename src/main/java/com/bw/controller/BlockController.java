package com.bw.controller;

import com.bw.api.BitcoinApi;
import com.bw.api.BitcoinJsonRpcClient;
import com.bw.dto.BlockDetailDTO;
import com.bw.dto.BlockListDTO;
import com.bw.mapper.BlockMapper;
import com.bw.po.Block;
import com.bw.service.BlockService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/block")
@CrossOrigin
public class BlockController {

    @Autowired
    private BitcoinApi bitcoinApi;

    @Autowired
    private BitcoinJsonRpcClient bitcoinJsonRpcClient;

    @Autowired
    private BlockMapper blockMapper;

    @Autowired
    private BlockService blockService;

    @Value("${blockchain.recentCount}")
    private Integer recentCount;

    @GetMapping("/getRecentBlocks")
    public List<BlockListDTO> getRecentBlocks() throws Throwable {

            List<Block> blocks = blockService.selectRecent();
            List<BlockListDTO> blockListDTOS = blocks.stream().map(block -> {
            BlockListDTO blockListDTO = new BlockListDTO();
            blockListDTO.setBlockhash(block.getBlockhash());
            blockListDTO.setHeight(block.getHeight());
            blockListDTO.setTime(block.getTime().getTime());
            blockListDTO.setTxSize(block.getTxSize());
            blockListDTO.setSizeOnDisk(block.getSizeOnDisk());
            return blockListDTO;
        }).collect(Collectors.toList());

        return blockListDTOS;
    }

    @GetMapping("/getRecentBlocksByNameType")
    public List<BlockListDTO> getRecentBlocksByNameType(@RequestParam String name,
                                                          @RequestParam String type,Block block,Map<String,Object> map){

        if(block.getBlockhash().equals(" ") && block.getBlockhash().trim()!=""){
             map.put("name",block.getBlockhash());
        }
        return null;
    }

    @GetMapping("/getBlockDetailByHash")
    public BlockDetailDTO getBlockDetailByHash(@RequestParam String blockhash){
        Block block = blockService.getBlockDetail(blockhash);
        BlockDetailDTO blockDetailDTO = new BlockDetailDTO(block);
        return blockDetailDTO;
    }

    @GetMapping("/getBlockDetailByHeight")
    public BlockDetailDTO getBlockDetailByHeight(@RequestParam Integer blockheight){
        return null;
    }
}
