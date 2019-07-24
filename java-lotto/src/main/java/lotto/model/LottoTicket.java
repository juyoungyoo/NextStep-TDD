package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {

    private List<Lotto> lottos;

    private LottoTicket(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public static LottoTicket of(List<Lotto> lottos) {
        return new LottoTicket(lottos);
    }

    public LottoResult result(WinningLotto winningLotto) {
        List<Prize> prizes = new ArrayList<>();
        for (Lotto lotto : lottos) {
            Prize prize = winningLotto.match(lotto);
            prizes.add(prize);
        }
        return LottoResult.of(prizes);
    }

    public LottoTicket merge(LottoTicket lottoTicket) {
        List<Lotto> lottos = new ArrayList<>();
        lottos.addAll(this.lottos);
        lottos.addAll(lottoTicket.lottos);
        return of(lottos);
    }

    public long countOfLotto() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}