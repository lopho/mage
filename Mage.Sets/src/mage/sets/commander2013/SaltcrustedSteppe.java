/*
 *  Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 *
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 *
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and should not be interpreted as representing official policies, either expressed
 *  or implied, of BetaSteward_at_googlemail.com.
 */
package mage.sets.commander2013;

import java.util.UUID;
import mage.abilities.Ability;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.costs.common.RemoveVariableCountersSourceCost;
import mage.abilities.costs.common.TapSourceCost;
import mage.abilities.costs.mana.GenericManaCost;
import mage.abilities.dynamicvalue.common.RemovedCountersForCostValue;
import mage.abilities.effects.common.AddManaInAnyCombinationEffect;
import mage.abilities.effects.common.counter.AddCountersSourceEffect;
import mage.abilities.mana.ColorlessManaAbility;
import mage.cards.CardImpl;
import mage.constants.CardType;
import mage.constants.ColoredManaSymbol;
import mage.constants.Rarity;
import mage.constants.Zone;
import mage.counters.CounterType;

/**
 *
 * @author LevelX2
 */
public class SaltcrustedSteppe extends CardImpl {

    public SaltcrustedSteppe(UUID ownerId) {
        super(ownerId, 316, "Saltcrusted Steppe", Rarity.UNCOMMON, new CardType[]{CardType.LAND}, "");
        this.expansionSetCode = "C13";

        // {tap}: Add {1} to your mana pool.
        this.addAbility(new ColorlessManaAbility());
        // {1}, {tap}: Put a storage counter on Saltcrusted Steppe.
        Ability ability = new SimpleActivatedAbility(Zone.BATTLEFIELD, new AddCountersSourceEffect(CounterType.STORAGE.createInstance()),new GenericManaCost(1));
        ability.addCost(new TapSourceCost());
        this.addAbility(ability);
        // {1}, Remove X storage counters from Saltcrusted Steppe: Add X mana in any combination of {G} and/or {W} to your mana pool.
        ability = new SimpleActivatedAbility(Zone.BATTLEFIELD,
                new AddManaInAnyCombinationEffect(new RemovedCountersForCostValue(), ColoredManaSymbol.G, ColoredManaSymbol.W),
                new GenericManaCost(1));
        ability.addCost(new RemoveVariableCountersSourceCost(CounterType.STORAGE.createInstance()));
        this.addAbility(ability);

    }

    public SaltcrustedSteppe(final SaltcrustedSteppe card) {
        super(card);
    }

    @Override
    public SaltcrustedSteppe copy() {
        return new SaltcrustedSteppe(this);
    }
}
