package com.bw.service;

import com.bw.po.Block;

import java.util.List;

public interface BlockService {


    Block getBlockDetail(String blockhash);


    List<Block> selectRecent();
}
