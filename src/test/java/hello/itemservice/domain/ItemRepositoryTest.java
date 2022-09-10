package hello.itemservice.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

//스프링없이 테스트 하는거임
class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    //테스트할때마다 저장 초기화 하기위함
    @AfterEach
    void afterEach() {
        itemRepository.cleanStore();
    }

    @Test
    void save() {
        //given
        Item item = new Item("itemA", 10000, 10);

        Item saveItem = itemRepository.save(item);
        //when
        Item findItem = itemRepository.findById(item.getId());

        //then
        assertThat(findItem).isEqualTo(saveItem);

    }

    @Test
    void finnAll() {
        //given
        Item item1 = new Item("item1", 10000, 10);
        Item item2 = new Item("item2", 20000, 20);

        itemRepository.save(item1);
        itemRepository.save(item2);
        //when
        List<Item> result = itemRepository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(item1, item2);
    }

    @Test
    void updateItem() {
        //given
        Item item = new Item("item1", 10000, 10);
        Item savedItem = itemRepository.save(item);
        Long itemId = savedItem.getId();

        //when
        Item updateParam = new Item("item2", 20000, 30);
        itemRepository.update(itemId, updateParam);
        //then
        Item findItem = itemRepository.findById(itemId);

        assertThat(findItem.getItemName()).isEqualTo(updateParam.getItemName());
        assertThat(findItem.getPrice()).isEqualTo(updateParam.getPrice());
        assertThat(findItem.getQuantity()).isEqualTo(updateParam.getQuantity());
    }
}