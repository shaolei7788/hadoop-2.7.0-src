BUILD_DIR="H:\Workspaces\hadoop-2.7.0-src\hadoop-project-dist\target"
                      TAR='tar cf -'
                      UNTAR='tar xfBp -'
                      LIB_DIR="${BUILD_DIR}/native/target/usr/local/lib"
                      if [ -d ${LIB_DIR} ] ; then
                        TARGET_DIR="${BUILD_DIR}/hadoop-project-dist-2.7.0/lib/native"
                        mkdir -p ${TARGET_DIR}
                        cd ${LIB_DIR}
                        $TAR lib* | (cd ${TARGET_DIR}/; $UNTAR)
                        if [ "false" = "true" ] ; then
                          cd "${snappy.lib}"
                          $TAR *snappy* | (cd ${TARGET_DIR}/; $UNTAR)
                        fi
                        if [ "false" = "true" ] ; then
                          cd "${openssl.lib}"
                          $TAR *crypto* | (cd ${TARGET_DIR}/; $UNTAR)
                        fi
                      fi
                      BIN_DIR="${BUILD_DIR}/bin"
                      if [ -d ${BIN_DIR} ] ; then
                        TARGET_BIN_DIR="${BUILD_DIR}/hadoop-project-dist-2.7.0/bin"
                        mkdir -p ${TARGET_BIN_DIR}
                        cd ${BIN_DIR}
                        $TAR * | (cd ${TARGET_BIN_DIR}/; $UNTAR)
                        if [ "false" = "true" ] ; then
                          if [ "false" = "true" ] ; then
                            cd "${snappy.lib}"
                            $TAR *snappy* | (cd ${TARGET_BIN_DIR}/; $UNTAR)
                          fi
                        fi
                        if [ "false" = "true" ] ; then
                          if [ "false" = "true" ] ; then
                            cd "${openssl.lib}"
                            $TAR *crypto* | (cd ${TARGET_BIN_DIR}/; $UNTAR)
                          fi
                        fi
                      fi