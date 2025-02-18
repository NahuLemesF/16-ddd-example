package com.buildingblocks.appointments.domain.table;

import com.buildingblocks.appointments.domain.table.entities.Card;
import com.buildingblocks.appointments.domain.table.entities.Player;
import com.buildingblocks.appointments.domain.table.events.AddedPlayer;
import com.buildingblocks.appointments.domain.table.events.CreatedTable;
import com.buildingblocks.appointments.domain.table.values.Emoji;
import com.buildingblocks.appointments.domain.table.values.IsActive;
import com.buildingblocks.appointments.domain.table.values.IsFlipped;
import com.buildingblocks.appointments.domain.table.values.Name;
import com.buildingblocks.appointments.domain.table.values.Nickname;
import com.buildingblocks.appointments.domain.table.values.PlayerId;
import com.buildingblocks.appointments.domain.table.values.Score;
import com.buildingblocks.shared.domain.generic.DomainActionsContainer;
import com.buildingblocks.shared.domain.generic.DomainEvent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

public class TableHandler extends DomainActionsContainer {
  public TableHandler(Table table) {
    add(createTable(table));
    add(addPlayer(table));
  }

  public Consumer<? extends DomainEvent> createTable(Table table) {
    return (CreatedTable event) -> {
      table.setName(Name.of(event.getName()));

      List<Card> row1 = Arrays.asList(
        new Card(Emoji.of("😈"), IsActive.of(true), IsFlipped.of(false)),
        new Card(Emoji.of("🎮"), IsActive.of(true), IsFlipped.of(false)),
        new Card(Emoji.of("🌟"), IsActive.of(true), IsFlipped.of(false)),
        new Card(Emoji.of("🎨"), IsActive.of(true), IsFlipped.of(false))
      );

      List<Card> row2 = Arrays.asList(
        new Card(Emoji.of("🎮"), IsActive.of(true), IsFlipped.of(false)),
        new Card(Emoji.of("🎨"), IsActive.of(true), IsFlipped.of(false)),
        new Card(Emoji.of("🌟"), IsActive.of(true), IsFlipped.of(false)),
        new Card(Emoji.of("😈"), IsActive.of(true), IsFlipped.of(false))
      );

      List<Card> row3 = Arrays.asList(
        new Card(Emoji.of("🎭"), IsActive.of(true), IsFlipped.of(false)),
        new Card(Emoji.of("🎪"), IsActive.of(true), IsFlipped.of(false)),
        new Card(Emoji.of("🎯"), IsActive.of(true), IsFlipped.of(false)),
        new Card(Emoji.of("🎲"), IsActive.of(true), IsFlipped.of(false))
      );

      List<Card> row4 = Arrays.asList(
        new Card(Emoji.of("🎲"), IsActive.of(true), IsFlipped.of(false)),
        new Card(Emoji.of("🎭"), IsActive.of(true), IsFlipped.of(false)),
        new Card(Emoji.of("🎪"), IsActive.of(true), IsFlipped.of(false)),
        new Card(Emoji.of("🎯"), IsActive.of(true), IsFlipped.of(false))
      );

      List<List<Card>> cards = Arrays.asList(row1, row2, row3, row4);
      table.setCards(cards);
      table.setPlayers(new HashMap<>());
    };
  }

  public Consumer<? extends DomainEvent> addPlayer(Table table) {
    return (AddedPlayer event) -> {
      table.validatePlayersQuantity();

      Player player = new Player(Nickname.of(event.getNickname()), Score.of(0));

      table.getPlayers().put(player.getIdentity(), player);
    };
  }
}
