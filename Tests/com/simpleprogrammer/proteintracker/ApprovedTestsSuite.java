package com.simpleprogrammer.proteintracker;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(ApprovedTestsCategory.class)
@Categories.ExcludeCategory(InProcessTestsCategory.class)
@Suite.SuiteClasses({
        HistoryItemTest.class,
        TrackingServiceTest.class
})
public class ApprovedTestsSuite {
}
