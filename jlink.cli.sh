rm -rf ./image && \
jlink --module-path mods/jarred:$JAVA_HOME/jmods            \
      --add-modules easytext.cli                            \
      --add-modules easytext.algorithm.coleman              \
      --add-modules easytext.algorithm.kincaid              \
      --add-modules easytext.algorithm.naivesyllablecounter \
      --launcher cli=easytext.cli                           \
      --strip-debug                                         \
      --compress=2                                          \
      --output image
