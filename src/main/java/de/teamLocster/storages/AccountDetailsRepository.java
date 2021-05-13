package de.teamLocster.storages;

import de.teamLocster.domains.AccountDetails;

public class AccountDetailsRepository extends BaseRepository<AccountDetails> {
    public AccountDetailsRepository() {
        super(AccountDetails.class, H2Controller.getManager().getEntityManager());
    }
}
