package kz.nik.middle.middlesecurity.api;

import kz.nik.middle.middlesecurity.dto.ItemDto;
import kz.nik.middle.middlesecurity.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/item")
public class ItemController {

    private final ItemService itemService;

    @GetMapping(value = "/item-list")
    public String itemList(){
        return "This is itemList";
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('Manager', 'Admin')")
    public List<ItemDto> getItems(){
        return itemService.getItems();
    }

    @GetMapping(value = "/admin")
    @PreAuthorize("hasAnyRole('Admin')")
    public String adminPage(){
        return "This is admin page";
    }
}
