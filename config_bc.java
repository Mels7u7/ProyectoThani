package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class config_bc extends GXWebPanel implements IGxSilentTrn
{
   public config_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public config_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( config_bc.class ));
   }

   public config_bc( int remoteHandle ,
                     ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow0G23( ) ;
      standaloneNotModal( ) ;
      initializeNonKey0G23( ) ;
      standaloneModal( ) ;
      addRow0G23( ) ;
      Gx_mode = "INS" ;
   }

   public void afterTrn( )
   {
      if ( trnEnded == 1 )
      {
         if ( ! (GXutil.strcmp("", endTrnMsgTxt)==0) )
         {
            httpContext.GX_msglist.addItem(endTrnMsgTxt, endTrnMsgCod, 0, "", true);
         }
         /* Execute user event: After Trn */
         e110G2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z33ConfigId = A33ConfigId ;
            SetMode( "UPD") ;
         }
      }
      endTrnMsgTxt = "" ;
   }

   public String toString( )
   {
      return "" ;
   }

   public GXContentInfo getContentInfo( )
   {
      return (GXContentInfo)(null) ;
   }

   public boolean Reindex( )
   {
      return true ;
   }

   public void confirm_0G0( )
   {
      beforeValidate0G23( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0G23( ) ;
         }
         else
         {
            checkExtendedTable0G23( ) ;
            if ( AnyError == 0 )
            {
            }
            closeExtendedTableCursors0G23( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void e120G2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_SdtWWPContext1[0] = AV11WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV11WWPContext = GXv_SdtWWPContext1[0] ;
      AV8IsAuthorized = true ;
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV8IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConfig_Insert", GXv_boolean3) ;
         config_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV8IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV8IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConfig_Update", GXv_boolean3) ;
         config_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV8IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV8IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConfig_Delete", GXv_boolean3) ;
         config_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV8IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV13Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV9TrnContext.fromxml(AV10WebSession.getValue("TrnContext"), null, null);
   }

   public void e110G2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void zm0G23( int GX_JID )
   {
      if ( ( GX_JID == 2 ) || ( GX_JID == 0 ) )
      {
         Z127ConfigKey = A127ConfigKey ;
         Z128ConfigValue = A128ConfigValue ;
         Z129ConfigEstadoR = A129ConfigEstadoR ;
      }
      if ( GX_JID == -2 )
      {
         Z33ConfigId = A33ConfigId ;
         Z127ConfigKey = A127ConfigKey ;
         Z128ConfigValue = A128ConfigValue ;
         Z129ConfigEstadoR = A129ConfigEstadoR ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
   }

   public void load0G23( )
   {
      /* Using cursor BC000G4 */
      pr_default.execute(2, new Object[] {Short.valueOf(A33ConfigId)});
      if ( (pr_default.getStatus(2) != 101) )
      {
         RcdFound23 = (short)(1) ;
         A127ConfigKey = BC000G4_A127ConfigKey[0] ;
         A128ConfigValue = BC000G4_A128ConfigValue[0] ;
         A129ConfigEstadoR = BC000G4_A129ConfigEstadoR[0] ;
         zm0G23( -2) ;
      }
      pr_default.close(2);
      onLoadActions0G23( ) ;
   }

   public void onLoadActions0G23( )
   {
      AV13Pgmname = "Config_BC" ;
   }

   public void checkExtendedTable0G23( )
   {
      nIsDirty_23 = (short)(0) ;
      standaloneModal( ) ;
      AV13Pgmname = "Config_BC" ;
      if ( ! ( ( GXutil.strcmp(A129ConfigEstadoR, "A") == 0 ) || ( GXutil.strcmp(A129ConfigEstadoR, "I") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Config Estado R fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors0G23( )
   {
   }

   public void enableDisable( )
   {
   }

   public void getKey0G23( )
   {
      /* Using cursor BC000G5 */
      pr_default.execute(3, new Object[] {Short.valueOf(A33ConfigId)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound23 = (short)(1) ;
      }
      else
      {
         RcdFound23 = (short)(0) ;
      }
      pr_default.close(3);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC000G6 */
      pr_default.execute(4, new Object[] {Short.valueOf(A33ConfigId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         zm0G23( 2) ;
         RcdFound23 = (short)(1) ;
         A33ConfigId = BC000G6_A33ConfigId[0] ;
         A127ConfigKey = BC000G6_A127ConfigKey[0] ;
         A128ConfigValue = BC000G6_A128ConfigValue[0] ;
         A129ConfigEstadoR = BC000G6_A129ConfigEstadoR[0] ;
         Z33ConfigId = A33ConfigId ;
         sMode23 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load0G23( ) ;
         if ( AnyError == 1 )
         {
            RcdFound23 = (short)(0) ;
            initializeNonKey0G23( ) ;
         }
         Gx_mode = sMode23 ;
      }
      else
      {
         RcdFound23 = (short)(0) ;
         initializeNonKey0G23( ) ;
         sMode23 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode23 ;
      }
      pr_default.close(4);
   }

   public void getEqualNoModal( )
   {
      getKey0G23( ) ;
      if ( RcdFound23 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
      }
      getByPrimaryKey( ) ;
   }

   public void insert_check( )
   {
      confirm_0G0( ) ;
      IsConfirmed = (short)(0) ;
   }

   public void update_check( )
   {
      insert_check( ) ;
   }

   public void delete_check( )
   {
      insert_check( ) ;
   }

   public void checkOptimisticConcurrency0G23( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000G7 */
         pr_default.execute(5, new Object[] {Short.valueOf(A33ConfigId)});
         if ( (pr_default.getStatus(5) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Config"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(5) == 101) || ( GXutil.strcmp(Z127ConfigKey, BC000G7_A127ConfigKey[0]) != 0 ) || ( GXutil.strcmp(Z128ConfigValue, BC000G7_A128ConfigValue[0]) != 0 ) || ( GXutil.strcmp(Z129ConfigEstadoR, BC000G7_A129ConfigEstadoR[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Config"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0G23( )
   {
      beforeValidate0G23( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0G23( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0G23( 0) ;
         checkOptimisticConcurrency0G23( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0G23( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0G23( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000G8 */
                  pr_default.execute(6, new Object[] {A127ConfigKey, A128ConfigValue, A129ConfigEstadoR});
                  A33ConfigId = BC000G8_A33ConfigId[0] ;
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Config");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
         else
         {
            load0G23( ) ;
         }
         endLevel0G23( ) ;
      }
      closeExtendedTableCursors0G23( ) ;
   }

   public void update0G23( )
   {
      beforeValidate0G23( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0G23( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0G23( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0G23( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0G23( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000G9 */
                  pr_default.execute(7, new Object[] {A127ConfigKey, A128ConfigValue, A129ConfigEstadoR, Short.valueOf(A33ConfigId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Config");
                  if ( (pr_default.getStatus(7) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Config"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0G23( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey( ) ;
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                        endTrnMsgCod = "SuccessfullyUpdated" ;
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
         endLevel0G23( ) ;
      }
      closeExtendedTableCursors0G23( ) ;
   }

   public void deferredUpdate0G23( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0G23( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0G23( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0G23( ) ;
         afterConfirm0G23( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0G23( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000G10 */
               pr_default.execute(8, new Object[] {Short.valueOf(A33ConfigId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Config");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucdeleted") ;
                     endTrnMsgCod = "SuccessfullyDeleted" ;
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode23 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0G23( ) ;
      Gx_mode = sMode23 ;
   }

   public void onDeleteControls0G23( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV13Pgmname = "Config_BC" ;
      }
   }

   public void endLevel0G23( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(5);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0G23( ) ;
      }
      if ( AnyError == 0 )
      {
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart0G23( )
   {
      /* Scan By routine */
      /* Using cursor BC000G11 */
      pr_default.execute(9, new Object[] {Short.valueOf(A33ConfigId)});
      RcdFound23 = (short)(0) ;
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound23 = (short)(1) ;
         A33ConfigId = BC000G11_A33ConfigId[0] ;
         A127ConfigKey = BC000G11_A127ConfigKey[0] ;
         A128ConfigValue = BC000G11_A128ConfigValue[0] ;
         A129ConfigEstadoR = BC000G11_A129ConfigEstadoR[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0G23( )
   {
      /* Scan next routine */
      pr_default.readNext(9);
      RcdFound23 = (short)(0) ;
      scanKeyLoad0G23( ) ;
   }

   public void scanKeyLoad0G23( )
   {
      sMode23 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound23 = (short)(1) ;
         A33ConfigId = BC000G11_A33ConfigId[0] ;
         A127ConfigKey = BC000G11_A127ConfigKey[0] ;
         A128ConfigValue = BC000G11_A128ConfigValue[0] ;
         A129ConfigEstadoR = BC000G11_A129ConfigEstadoR[0] ;
      }
      Gx_mode = sMode23 ;
   }

   public void scanKeyEnd0G23( )
   {
      pr_default.close(9);
   }

   public void afterConfirm0G23( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0G23( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0G23( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0G23( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0G23( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0G23( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0G23( )
   {
   }

   public void send_integrity_lvl_hashes0G23( )
   {
   }

   public void addRow0G23( )
   {
      VarsToRow23( bcConfig) ;
   }

   public void readRow0G23( )
   {
      RowToVars23( bcConfig, 1) ;
   }

   public void initializeNonKey0G23( )
   {
      A127ConfigKey = "" ;
      A128ConfigValue = "" ;
      A129ConfigEstadoR = "" ;
      Z127ConfigKey = "" ;
      Z128ConfigValue = "" ;
      Z129ConfigEstadoR = "" ;
   }

   public void initAll0G23( )
   {
      A33ConfigId = (short)(0) ;
      initializeNonKey0G23( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public boolean isIns( )
   {
      return ((GXutil.strcmp(Gx_mode, "INS")==0) ? true : false) ;
   }

   public boolean isDlt( )
   {
      return ((GXutil.strcmp(Gx_mode, "DLT")==0) ? true : false) ;
   }

   public boolean isUpd( )
   {
      return ((GXutil.strcmp(Gx_mode, "UPD")==0) ? true : false) ;
   }

   public boolean isDsp( )
   {
      return ((GXutil.strcmp(Gx_mode, "DSP")==0) ? true : false) ;
   }

   public void VarsToRow23( com.projectthani.SdtConfig obj23 )
   {
      obj23.setgxTv_SdtConfig_Mode( Gx_mode );
      obj23.setgxTv_SdtConfig_Configkey( A127ConfigKey );
      obj23.setgxTv_SdtConfig_Configvalue( A128ConfigValue );
      obj23.setgxTv_SdtConfig_Configestador( A129ConfigEstadoR );
      obj23.setgxTv_SdtConfig_Configid( A33ConfigId );
      obj23.setgxTv_SdtConfig_Configid_Z( Z33ConfigId );
      obj23.setgxTv_SdtConfig_Configkey_Z( Z127ConfigKey );
      obj23.setgxTv_SdtConfig_Configvalue_Z( Z128ConfigValue );
      obj23.setgxTv_SdtConfig_Configestador_Z( Z129ConfigEstadoR );
      obj23.setgxTv_SdtConfig_Mode( Gx_mode );
   }

   public void KeyVarsToRow23( com.projectthani.SdtConfig obj23 )
   {
      obj23.setgxTv_SdtConfig_Configid( A33ConfigId );
   }

   public void RowToVars23( com.projectthani.SdtConfig obj23 ,
                            int forceLoad )
   {
      Gx_mode = obj23.getgxTv_SdtConfig_Mode() ;
      A127ConfigKey = obj23.getgxTv_SdtConfig_Configkey() ;
      A128ConfigValue = obj23.getgxTv_SdtConfig_Configvalue() ;
      A129ConfigEstadoR = obj23.getgxTv_SdtConfig_Configestador() ;
      A33ConfigId = obj23.getgxTv_SdtConfig_Configid() ;
      Z33ConfigId = obj23.getgxTv_SdtConfig_Configid_Z() ;
      Z127ConfigKey = obj23.getgxTv_SdtConfig_Configkey_Z() ;
      Z128ConfigValue = obj23.getgxTv_SdtConfig_Configvalue_Z() ;
      Z129ConfigEstadoR = obj23.getgxTv_SdtConfig_Configestador_Z() ;
      Gx_mode = obj23.getgxTv_SdtConfig_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A33ConfigId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.SHORT)).shortValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey0G23( ) ;
      scanKeyStart0G23( ) ;
      if ( RcdFound23 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z33ConfigId = A33ConfigId ;
      }
      zm0G23( -2) ;
      onLoadActions0G23( ) ;
      addRow0G23( ) ;
      scanKeyEnd0G23( ) ;
      if ( RcdFound23 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void Load( )
   {
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      RowToVars23( bcConfig, 0) ;
      scanKeyStart0G23( ) ;
      if ( RcdFound23 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z33ConfigId = A33ConfigId ;
      }
      zm0G23( -2) ;
      onLoadActions0G23( ) ;
      addRow0G23( ) ;
      scanKeyEnd0G23( ) ;
      if ( RcdFound23 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0G23( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert0G23( ) ;
      }
      else
      {
         if ( RcdFound23 == 1 )
         {
            if ( A33ConfigId != Z33ConfigId )
            {
               A33ConfigId = Z33ConfigId ;
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "");
               AnyError = (short)(1) ;
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               /* Update record */
               update0G23( ) ;
            }
         }
         else
         {
            if ( isDlt( ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "");
               AnyError = (short)(1) ;
            }
            else
            {
               if ( A33ConfigId != Z33ConfigId )
               {
                  if ( isUpd( ) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  else
                  {
                     Gx_mode = "INS" ;
                     /* Insert record */
                     insert0G23( ) ;
                  }
               }
               else
               {
                  if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
                     AnyError = (short)(1) ;
                  }
                  else
                  {
                     Gx_mode = "INS" ;
                     /* Insert record */
                     insert0G23( ) ;
                  }
               }
            }
         }
      }
      afterTrn( ) ;
   }

   public void Save( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars23( bcConfig, 1) ;
      saveImpl( ) ;
      VarsToRow23( bcConfig) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars23( bcConfig, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0G23( ) ;
      afterTrn( ) ;
      VarsToRow23( bcConfig) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void updateImpl( )
   {
      if ( isUpd( ) )
      {
         saveImpl( ) ;
      }
      else
      {
         com.projectthani.SdtConfig auxBC = new com.projectthani.SdtConfig( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A33ConfigId);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcConfig);
            auxBC.Save();
         }
         LclMsgLst = auxTrn.GetMessages() ;
         AnyError = (short)(auxTrn.Errors()) ;
         httpContext.GX_msglist = LclMsgLst ;
         if ( auxTrn.Errors() == 0 )
         {
            Gx_mode = auxTrn.GetMode() ;
            afterTrn( ) ;
         }
      }
   }

   public boolean Update( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars23( bcConfig, 1) ;
      updateImpl( ) ;
      VarsToRow23( bcConfig) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public boolean InsertOrUpdate( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars23( bcConfig, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0G23( ) ;
      if ( AnyError == 1 )
      {
         if ( GXutil.strcmp(httpContext.GX_msglist.getItemValue((short)(1)), "DuplicatePrimaryKey") == 0 )
         {
            AnyError = (short)(0) ;
            httpContext.GX_msglist.removeAllItems();
            updateImpl( ) ;
         }
      }
      else
      {
         afterTrn( ) ;
      }
      VarsToRow23( bcConfig) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars23( bcConfig, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey0G23( ) ;
      if ( RcdFound23 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( A33ConfigId != Z33ConfigId )
         {
            A33ConfigId = Z33ConfigId ;
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( isDlt( ) )
         {
            delete_check( ) ;
         }
         else
         {
            Gx_mode = "UPD" ;
            update_check( ) ;
         }
      }
      else
      {
         if ( A33ConfigId != Z33ConfigId )
         {
            Gx_mode = "INS" ;
            insert_check( ) ;
         }
         else
         {
            if ( isUpd( ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
               AnyError = (short)(1) ;
            }
            else
            {
               Gx_mode = "INS" ;
               insert_check( ) ;
            }
         }
      }
      pr_default.close(1);
      pr_default.close(0);
      Application.rollbackDataStores(context, remoteHandle, pr_default, "config_bc");
      VarsToRow23( bcConfig) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public int Errors( )
   {
      if ( AnyError == 0 )
      {
         return 0 ;
      }
      return 1 ;
   }

   public com.genexus.internet.MsgList GetMessages( )
   {
      return LclMsgLst ;
   }

   public String GetMode( )
   {
      Gx_mode = bcConfig.getgxTv_SdtConfig_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcConfig.setgxTv_SdtConfig_Mode( Gx_mode );
   }

   public void SetSDT( com.projectthani.SdtConfig sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcConfig )
      {
         bcConfig = sdt ;
         if ( GXutil.strcmp(bcConfig.getgxTv_SdtConfig_Mode(), "") == 0 )
         {
            bcConfig.setgxTv_SdtConfig_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow23( bcConfig) ;
         }
         else
         {
            RowToVars23( bcConfig, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcConfig.getgxTv_SdtConfig_Mode(), "") == 0 )
         {
            bcConfig.setgxTv_SdtConfig_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars23( bcConfig, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtConfig getConfig_BC( )
   {
      return bcConfig ;
   }


   public void webExecute( )
   {
   }

   protected void createObjects( )
   {
   }

   protected void Process( )
   {
   }

   protected void cleanup( )
   {
      super.cleanup();
      CloseOpenCursors();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Gx_mode = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV11WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV13Pgmname = "" ;
      AV9TrnContext = new com.projectthani.SdtTransactionContext(remoteHandle, context);
      AV10WebSession = httpContext.getWebSession();
      Z127ConfigKey = "" ;
      A127ConfigKey = "" ;
      Z128ConfigValue = "" ;
      A128ConfigValue = "" ;
      Z129ConfigEstadoR = "" ;
      A129ConfigEstadoR = "" ;
      BC000G4_A33ConfigId = new short[1] ;
      BC000G4_A127ConfigKey = new String[] {""} ;
      BC000G4_A128ConfigValue = new String[] {""} ;
      BC000G4_A129ConfigEstadoR = new String[] {""} ;
      BC000G5_A33ConfigId = new short[1] ;
      BC000G6_A33ConfigId = new short[1] ;
      BC000G6_A127ConfigKey = new String[] {""} ;
      BC000G6_A128ConfigValue = new String[] {""} ;
      BC000G6_A129ConfigEstadoR = new String[] {""} ;
      sMode23 = "" ;
      BC000G7_A33ConfigId = new short[1] ;
      BC000G7_A127ConfigKey = new String[] {""} ;
      BC000G7_A128ConfigValue = new String[] {""} ;
      BC000G7_A129ConfigEstadoR = new String[] {""} ;
      BC000G8_A33ConfigId = new short[1] ;
      BC000G11_A33ConfigId = new short[1] ;
      BC000G11_A127ConfigKey = new String[] {""} ;
      BC000G11_A128ConfigValue = new String[] {""} ;
      BC000G11_A129ConfigEstadoR = new String[] {""} ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.config_bc__default(),
         new Object[] {
             new Object[] {
            BC000G2_A33ConfigId, BC000G2_A127ConfigKey, BC000G2_A128ConfigValue, BC000G2_A129ConfigEstadoR
            }
            , new Object[] {
            BC000G3_A33ConfigId, BC000G3_A127ConfigKey, BC000G3_A128ConfigValue, BC000G3_A129ConfigEstadoR
            }
            , new Object[] {
            BC000G4_A33ConfigId, BC000G4_A127ConfigKey, BC000G4_A128ConfigValue, BC000G4_A129ConfigEstadoR
            }
            , new Object[] {
            BC000G5_A33ConfigId
            }
            , new Object[] {
            BC000G6_A33ConfigId, BC000G6_A127ConfigKey, BC000G6_A128ConfigValue, BC000G6_A129ConfigEstadoR
            }
            , new Object[] {
            BC000G7_A33ConfigId, BC000G7_A127ConfigKey, BC000G7_A128ConfigValue, BC000G7_A129ConfigEstadoR
            }
            , new Object[] {
            BC000G8_A33ConfigId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000G11_A33ConfigId, BC000G11_A127ConfigKey, BC000G11_A128ConfigValue, BC000G11_A129ConfigEstadoR
            }
         }
      );
      AV13Pgmname = "Config_BC" ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e120G2 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z33ConfigId ;
   private short A33ConfigId ;
   private short RcdFound23 ;
   private short nIsDirty_23 ;
   private int trnEnded ;
   private int GX_JID ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String AV13Pgmname ;
   private String Z129ConfigEstadoR ;
   private String A129ConfigEstadoR ;
   private String sMode23 ;
   private boolean returnInSub ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean mustCommit ;
   private String Z127ConfigKey ;
   private String A127ConfigKey ;
   private String Z128ConfigValue ;
   private String A128ConfigValue ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV10WebSession ;
   private com.projectthani.SdtConfig bcConfig ;
   private IDataStoreProvider pr_default ;
   private short[] BC000G4_A33ConfigId ;
   private String[] BC000G4_A127ConfigKey ;
   private String[] BC000G4_A128ConfigValue ;
   private String[] BC000G4_A129ConfigEstadoR ;
   private short[] BC000G5_A33ConfigId ;
   private short[] BC000G6_A33ConfigId ;
   private String[] BC000G6_A127ConfigKey ;
   private String[] BC000G6_A128ConfigValue ;
   private String[] BC000G6_A129ConfigEstadoR ;
   private short[] BC000G7_A33ConfigId ;
   private String[] BC000G7_A127ConfigKey ;
   private String[] BC000G7_A128ConfigValue ;
   private String[] BC000G7_A129ConfigEstadoR ;
   private short[] BC000G8_A33ConfigId ;
   private short[] BC000G11_A33ConfigId ;
   private String[] BC000G11_A127ConfigKey ;
   private String[] BC000G11_A128ConfigValue ;
   private String[] BC000G11_A129ConfigEstadoR ;
   private short[] BC000G2_A33ConfigId ;
   private String[] BC000G2_A127ConfigKey ;
   private String[] BC000G2_A128ConfigValue ;
   private String[] BC000G2_A129ConfigEstadoR ;
   private short[] BC000G3_A33ConfigId ;
   private String[] BC000G3_A127ConfigKey ;
   private String[] BC000G3_A128ConfigValue ;
   private String[] BC000G3_A129ConfigEstadoR ;
   private com.projectthani.SdtTransactionContext AV9TrnContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV11WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
}

final  class config_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC000G2", "SELECT [ConfigId], [ConfigKey], [ConfigValue], [ConfigEstadoR] FROM [Config] WITH (UPDLOCK) WHERE [ConfigId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000G3", "SELECT [ConfigId], [ConfigKey], [ConfigValue], [ConfigEstadoR] FROM [Config] WHERE [ConfigId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000G4", "SELECT TM1.[ConfigId], TM1.[ConfigKey], TM1.[ConfigValue], TM1.[ConfigEstadoR] FROM [Config] TM1 WHERE TM1.[ConfigId] = ? ORDER BY TM1.[ConfigId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000G5", "SELECT [ConfigId] FROM [Config] WHERE [ConfigId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000G6", "SELECT [ConfigId], [ConfigKey], [ConfigValue], [ConfigEstadoR] FROM [Config] WHERE [ConfigId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000G7", "SELECT [ConfigId], [ConfigKey], [ConfigValue], [ConfigEstadoR] FROM [Config] WITH (UPDLOCK) WHERE [ConfigId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000G8", "INSERT INTO [Config]([ConfigKey], [ConfigValue], [ConfigEstadoR]) VALUES(?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("BC000G9", "UPDATE [Config] SET [ConfigKey]=?, [ConfigValue]=?, [ConfigEstadoR]=?  WHERE [ConfigId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC000G10", "DELETE FROM [Config]  WHERE [ConfigId] = ?", GX_NOMASK)
         ,new ForEachCursor("BC000G11", "SELECT TM1.[ConfigId], TM1.[ConfigKey], TM1.[ConfigValue], TM1.[ConfigEstadoR] FROM [Config] TM1 WHERE TM1.[ConfigId] = ? ORDER BY TM1.[ConfigId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 9 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 6 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setVarchar(2, (String)parms[1], 500, false);
               stmt.setString(3, (String)parms[2], 1);
               return;
            case 7 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setVarchar(2, (String)parms[1], 500, false);
               stmt.setString(3, (String)parms[2], 1);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 8 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 9 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

