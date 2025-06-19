package com.example.demo.service.impl;
import com.example.demo.mapper.MenuMapper;
import com.example.demo.model.Menu;
import com.example.demo.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MenuServiceImpl implements MenuService {

  private final MenuMapper menuMapper;

  public List<Menu> getMenus() {
    return menuMapper.findMenus();
  }
}
