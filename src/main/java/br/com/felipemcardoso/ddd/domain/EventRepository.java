package br.com.felipemcardoso.ddd.domain;

import java.util.List;

/**
 * Created by Felipe on 4/21/15.
 */
public interface EventRepository extends IRepository<Event, EventId> {

    void adicionar(Event event);

    void alterarEventoParaPublicado(Event event);

    void alterarTipoEventoParaConsumido(Event event);

    List<Event> obterEventosTipoPublicadoNaoEnviados();

    void lockEvento();
}
