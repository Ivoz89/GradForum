/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gft.grad.forum.model.repo;

import com.gft.grad.forum.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author izielinski
 */
public interface BoardRepository extends JpaRepository<Board, Long> {

    Board findByName(String name);
}
