package de.teamLocster.storages;

import de.teamLocster.core.H2Controller;
import de.teamLocster.domains.AccountDetails;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AccountDetailsRepository extends BaseRepository<AccountDetails> {

    public AccountDetailsRepository() { super(AccountDetails.class, H2Controller.getManager().getEntityManager());}
}
