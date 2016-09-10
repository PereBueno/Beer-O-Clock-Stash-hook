package com.pbueno.atlassian.stash.plugins.hook;

import com.atlassian.stash.hook.*;
import com.atlassian.stash.hook.repository.*;
import com.atlassian.stash.repository.*;

import java.util.Calendar;
import java.util.Collection;

public class BeerOClockHook implements PreReceiveRepositoryHook
{
    @Override
    public boolean onReceive(RepositoryHookContext context, Collection<RefChange> refChanges, HookResponse hookResponse)
    {
        Calendar now = Calendar.getInstance();
        boolean isWeekend = (now.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) || (now.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY);
        boolean isFridayEvening = (now.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) && (now.get(Calendar.HOUR_OF_DAY) >= 16);
        if (isWeekend || isFridayEvening) {
            hookResponse.err().println("Sorry mate, no pushing allowed after 4pm on Fridays");
        }
        return !(isWeekend || isFridayEvening);

    }
}
