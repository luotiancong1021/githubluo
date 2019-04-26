package com.bw.service;

import com.bw.po.Block;

import java.util.List;

public interface BlockService {
    List<Block> selcectRecent();

    Block getBlockDetail(String blockhash);


}
