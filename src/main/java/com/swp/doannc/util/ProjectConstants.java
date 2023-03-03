package com.swp.doannc.util;

import java.util.Locale;

/**
 * InnerProjectConstants
 */
public final class ProjectConstants {

  public static final String DEFAULT_ENCODING = "UTF-8";

  public static final String PROJECT_BASE_PACKAGE = "com.swp.doannc";

  public static final Locale VIETNAM_LOCALE = new Locale.Builder().setLanguage("vi").setRegion("VN").build();

  private ProjectConstants() {

    throw new UnsupportedOperationException();
  }

}
