package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class logaccesos_bc extends GXWebPanel implements IGxSilentTrn
{
   public logaccesos_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public logaccesos_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( logaccesos_bc.class ));
   }

   public logaccesos_bc( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow0Q35( ) ;
      standaloneNotModal( ) ;
      initializeNonKey0Q35( ) ;
      standaloneModal( ) ;
      addRow0Q35( ) ;
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
         e110Q2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z41LogAccesosId = A41LogAccesosId ;
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

   public void confirm_0Q0( )
   {
      beforeValidate0Q35( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0Q35( ) ;
         }
         else
         {
            checkExtendedTable0Q35( ) ;
            if ( AnyError == 0 )
            {
               zm0Q35( 7) ;
               zm0Q35( 8) ;
               zm0Q35( 9) ;
            }
            closeExtendedTableCursors0Q35( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void e120Q2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_SdtWWPContext1[0] = AV8WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV8WWPContext = GXv_SdtWWPContext1[0] ;
      AV9IsAuthorized = true ;
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV9IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLogAccesos_Insert", GXv_boolean3) ;
         logaccesos_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV9IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV9IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLogAccesos_Update", GXv_boolean3) ;
         logaccesos_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV9IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV9IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLogAccesos_Delete", GXv_boolean3) ;
         logaccesos_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV9IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV9IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV25Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV11TrnContext.fromxml(AV12WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV11TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV25Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV26GXV1 = 1 ;
         while ( AV26GXV1 <= AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV14TrnContextAtt = (com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV26GXV1));
            if ( GXutil.strcmp(AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "SecUserId") == 0 )
            {
               AV13Insert_SecUserId = (short)(GXutil.lval( AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            else if ( GXutil.strcmp(AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "SecRoleId") == 0 )
            {
               AV15Insert_SecRoleId = (short)(GXutil.lval( AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            AV26GXV1 = (int)(AV26GXV1+1) ;
         }
      }
   }

   public void e110Q2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void zm0Q35( int GX_JID )
   {
      if ( ( GX_JID == 6 ) || ( GX_JID == 0 ) )
      {
         Z227LogAccesosTipo = A227LogAccesosTipo ;
         Z228LogAccesosFecha = A228LogAccesosFecha ;
         Z6SecUserId = A6SecUserId ;
         Z4SecRoleId = A4SecRoleId ;
         Z172LogAccesosFullName = A172LogAccesosFullName ;
      }
      if ( ( GX_JID == 7 ) || ( GX_JID == 0 ) )
      {
         Z14SecUserName = A14SecUserName ;
         Z172LogAccesosFullName = A172LogAccesosFullName ;
      }
      if ( ( GX_JID == 8 ) || ( GX_JID == 0 ) )
      {
         Z12SecRoleDescription = A12SecRoleDescription ;
         Z172LogAccesosFullName = A172LogAccesosFullName ;
      }
      if ( ( GX_JID == 9 ) || ( GX_JID == 0 ) )
      {
         Z172LogAccesosFullName = A172LogAccesosFullName ;
      }
      if ( GX_JID == -6 )
      {
         Z41LogAccesosId = A41LogAccesosId ;
         Z227LogAccesosTipo = A227LogAccesosTipo ;
         Z228LogAccesosFecha = A228LogAccesosFecha ;
         Z6SecUserId = A6SecUserId ;
         Z4SecRoleId = A4SecRoleId ;
         Z14SecUserName = A14SecUserName ;
         Z12SecRoleDescription = A12SecRoleDescription ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
   }

   public void load0Q35( )
   {
      /* Using cursor BC000Q7 */
      pr_default.execute(5, new Object[] {Short.valueOf(A41LogAccesosId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound35 = (short)(1) ;
         A14SecUserName = BC000Q7_A14SecUserName[0] ;
         A12SecRoleDescription = BC000Q7_A12SecRoleDescription[0] ;
         A227LogAccesosTipo = BC000Q7_A227LogAccesosTipo[0] ;
         A228LogAccesosFecha = BC000Q7_A228LogAccesosFecha[0] ;
         A6SecUserId = BC000Q7_A6SecUserId[0] ;
         A4SecRoleId = BC000Q7_A4SecRoleId[0] ;
         zm0Q35( -6) ;
      }
      pr_default.close(5);
      onLoadActions0Q35( ) ;
   }

   public void onLoadActions0Q35( )
   {
      AV25Pgmname = "LogAccesos_BC" ;
      GXt_char4 = A172LogAccesosFullName ;
      GXv_char5[0] = GXt_char4 ;
      new com.projectthani.prcgetnombreuser(remoteHandle, context).execute( A14SecUserName, A4SecRoleId, GXv_char5) ;
      logaccesos_bc.this.GXt_char4 = GXv_char5[0] ;
      A172LogAccesosFullName = GXt_char4 ;
   }

   public void checkExtendedTable0Q35( )
   {
      nIsDirty_35 = (short)(0) ;
      standaloneModal( ) ;
      AV25Pgmname = "LogAccesos_BC" ;
      /* Using cursor BC000Q8 */
      pr_default.execute(6, new Object[] {Short.valueOf(A6SecUserId)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'User'.", "ForeignKeyNotFound", 1, "SECUSERID");
         AnyError = (short)(1) ;
      }
      A14SecUserName = BC000Q8_A14SecUserName[0] ;
      pr_default.close(6);
      nIsDirty_35 = (short)(1) ;
      GXt_char4 = A172LogAccesosFullName ;
      GXv_char5[0] = GXt_char4 ;
      new com.projectthani.prcgetnombreuser(remoteHandle, context).execute( A14SecUserName, A4SecRoleId, GXv_char5) ;
      logaccesos_bc.this.GXt_char4 = GXv_char5[0] ;
      A172LogAccesosFullName = GXt_char4 ;
      /* Using cursor BC000Q9 */
      pr_default.execute(7, new Object[] {Short.valueOf(A6SecUserId), Short.valueOf(A4SecRoleId)});
      if ( (pr_default.getStatus(7) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Sec User Role'.", "ForeignKeyNotFound", 1, "SECROLEID");
         AnyError = (short)(1) ;
      }
      pr_default.close(7);
      /* Using cursor BC000Q10 */
      pr_default.execute(8, new Object[] {Short.valueOf(A4SecRoleId)});
      if ( (pr_default.getStatus(8) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Role'.", "ForeignKeyNotFound", 1, "SECROLEID");
         AnyError = (short)(1) ;
      }
      A12SecRoleDescription = BC000Q10_A12SecRoleDescription[0] ;
      pr_default.close(8);
      if ( ! ( ( GXutil.strcmp(A227LogAccesosTipo, "I") == 0 ) || ( GXutil.strcmp(A227LogAccesosTipo, "S") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Tipo fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), A228LogAccesosFecha) || (( A228LogAccesosFecha.after( localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0)) ) ) || ( GXutil.dateCompare(A228LogAccesosFecha, localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0))) )) ) )
      {
         httpContext.GX_msglist.addItem("Campo Fecha fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors0Q35( )
   {
      pr_default.close(6);
      pr_default.close(7);
      pr_default.close(8);
   }

   public void enableDisable( )
   {
   }

   public void getKey0Q35( )
   {
      /* Using cursor BC000Q11 */
      pr_default.execute(9, new Object[] {Short.valueOf(A41LogAccesosId)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound35 = (short)(1) ;
      }
      else
      {
         RcdFound35 = (short)(0) ;
      }
      pr_default.close(9);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC000Q12 */
      pr_default.execute(10, new Object[] {Short.valueOf(A41LogAccesosId)});
      if ( (pr_default.getStatus(10) != 101) )
      {
         zm0Q35( 6) ;
         RcdFound35 = (short)(1) ;
         A41LogAccesosId = BC000Q12_A41LogAccesosId[0] ;
         A227LogAccesosTipo = BC000Q12_A227LogAccesosTipo[0] ;
         A228LogAccesosFecha = BC000Q12_A228LogAccesosFecha[0] ;
         A6SecUserId = BC000Q12_A6SecUserId[0] ;
         A4SecRoleId = BC000Q12_A4SecRoleId[0] ;
         Z41LogAccesosId = A41LogAccesosId ;
         sMode35 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load0Q35( ) ;
         if ( AnyError == 1 )
         {
            RcdFound35 = (short)(0) ;
            initializeNonKey0Q35( ) ;
         }
         Gx_mode = sMode35 ;
      }
      else
      {
         RcdFound35 = (short)(0) ;
         initializeNonKey0Q35( ) ;
         sMode35 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode35 ;
      }
      pr_default.close(10);
   }

   public void getEqualNoModal( )
   {
      getKey0Q35( ) ;
      if ( RcdFound35 == 0 )
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
      confirm_0Q0( ) ;
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

   public void checkOptimisticConcurrency0Q35( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000Q13 */
         pr_default.execute(11, new Object[] {Short.valueOf(A41LogAccesosId)});
         if ( (pr_default.getStatus(11) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"LogAccesos"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(11) == 101) || ( GXutil.strcmp(Z227LogAccesosTipo, BC000Q13_A227LogAccesosTipo[0]) != 0 ) || !( GXutil.dateCompare(Z228LogAccesosFecha, BC000Q13_A228LogAccesosFecha[0]) ) || ( Z6SecUserId != BC000Q13_A6SecUserId[0] ) || ( Z4SecRoleId != BC000Q13_A4SecRoleId[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"LogAccesos"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0Q35( )
   {
      beforeValidate0Q35( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0Q35( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0Q35( 0) ;
         checkOptimisticConcurrency0Q35( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0Q35( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0Q35( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000Q14 */
                  pr_default.execute(12, new Object[] {A227LogAccesosTipo, A228LogAccesosFecha, Short.valueOf(A6SecUserId), Short.valueOf(A4SecRoleId)});
                  A41LogAccesosId = BC000Q14_A41LogAccesosId[0] ;
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("LogAccesos");
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
            load0Q35( ) ;
         }
         endLevel0Q35( ) ;
      }
      closeExtendedTableCursors0Q35( ) ;
   }

   public void update0Q35( )
   {
      beforeValidate0Q35( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0Q35( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0Q35( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0Q35( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0Q35( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000Q15 */
                  pr_default.execute(13, new Object[] {A227LogAccesosTipo, A228LogAccesosFecha, Short.valueOf(A6SecUserId), Short.valueOf(A4SecRoleId), Short.valueOf(A41LogAccesosId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("LogAccesos");
                  if ( (pr_default.getStatus(13) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"LogAccesos"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0Q35( ) ;
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
         endLevel0Q35( ) ;
      }
      closeExtendedTableCursors0Q35( ) ;
   }

   public void deferredUpdate0Q35( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0Q35( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0Q35( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0Q35( ) ;
         afterConfirm0Q35( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0Q35( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000Q16 */
               pr_default.execute(14, new Object[] {Short.valueOf(A41LogAccesosId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("LogAccesos");
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
      sMode35 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0Q35( ) ;
      Gx_mode = sMode35 ;
   }

   public void onDeleteControls0Q35( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV25Pgmname = "LogAccesos_BC" ;
         /* Using cursor BC000Q17 */
         pr_default.execute(15, new Object[] {Short.valueOf(A6SecUserId)});
         A14SecUserName = BC000Q17_A14SecUserName[0] ;
         pr_default.close(15);
         /* Using cursor BC000Q18 */
         pr_default.execute(16, new Object[] {Short.valueOf(A4SecRoleId)});
         A12SecRoleDescription = BC000Q18_A12SecRoleDescription[0] ;
         pr_default.close(16);
         GXt_char4 = A172LogAccesosFullName ;
         GXv_char5[0] = GXt_char4 ;
         new com.projectthani.prcgetnombreuser(remoteHandle, context).execute( A14SecUserName, A4SecRoleId, GXv_char5) ;
         logaccesos_bc.this.GXt_char4 = GXv_char5[0] ;
         A172LogAccesosFullName = GXt_char4 ;
      }
   }

   public void endLevel0Q35( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(11);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0Q35( ) ;
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

   public void scanKeyStart0Q35( )
   {
      /* Scan By routine */
      /* Using cursor BC000Q19 */
      pr_default.execute(17, new Object[] {Short.valueOf(A41LogAccesosId)});
      RcdFound35 = (short)(0) ;
      if ( (pr_default.getStatus(17) != 101) )
      {
         RcdFound35 = (short)(1) ;
         A41LogAccesosId = BC000Q19_A41LogAccesosId[0] ;
         A14SecUserName = BC000Q19_A14SecUserName[0] ;
         A12SecRoleDescription = BC000Q19_A12SecRoleDescription[0] ;
         A227LogAccesosTipo = BC000Q19_A227LogAccesosTipo[0] ;
         A228LogAccesosFecha = BC000Q19_A228LogAccesosFecha[0] ;
         A6SecUserId = BC000Q19_A6SecUserId[0] ;
         A4SecRoleId = BC000Q19_A4SecRoleId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0Q35( )
   {
      /* Scan next routine */
      pr_default.readNext(17);
      RcdFound35 = (short)(0) ;
      scanKeyLoad0Q35( ) ;
   }

   public void scanKeyLoad0Q35( )
   {
      sMode35 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(17) != 101) )
      {
         RcdFound35 = (short)(1) ;
         A41LogAccesosId = BC000Q19_A41LogAccesosId[0] ;
         A14SecUserName = BC000Q19_A14SecUserName[0] ;
         A12SecRoleDescription = BC000Q19_A12SecRoleDescription[0] ;
         A227LogAccesosTipo = BC000Q19_A227LogAccesosTipo[0] ;
         A228LogAccesosFecha = BC000Q19_A228LogAccesosFecha[0] ;
         A6SecUserId = BC000Q19_A6SecUserId[0] ;
         A4SecRoleId = BC000Q19_A4SecRoleId[0] ;
      }
      Gx_mode = sMode35 ;
   }

   public void scanKeyEnd0Q35( )
   {
      pr_default.close(17);
   }

   public void afterConfirm0Q35( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0Q35( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0Q35( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0Q35( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0Q35( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0Q35( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0Q35( )
   {
   }

   public void send_integrity_lvl_hashes0Q35( )
   {
   }

   public void addRow0Q35( )
   {
      VarsToRow35( bcLogAccesos) ;
   }

   public void readRow0Q35( )
   {
      RowToVars35( bcLogAccesos, 1) ;
   }

   public void initializeNonKey0Q35( )
   {
      A172LogAccesosFullName = "" ;
      A6SecUserId = (short)(0) ;
      A14SecUserName = "" ;
      A4SecRoleId = (short)(0) ;
      A12SecRoleDescription = "" ;
      A227LogAccesosTipo = "" ;
      A228LogAccesosFecha = GXutil.resetTime( GXutil.nullDate() );
      Z227LogAccesosTipo = "" ;
      Z228LogAccesosFecha = GXutil.resetTime( GXutil.nullDate() );
      Z6SecUserId = (short)(0) ;
      Z4SecRoleId = (short)(0) ;
   }

   public void initAll0Q35( )
   {
      A41LogAccesosId = (short)(0) ;
      initializeNonKey0Q35( ) ;
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

   public void VarsToRow35( com.projectthani.SdtLogAccesos obj35 )
   {
      obj35.setgxTv_SdtLogAccesos_Mode( Gx_mode );
      obj35.setgxTv_SdtLogAccesos_Logaccesosfullname( A172LogAccesosFullName );
      obj35.setgxTv_SdtLogAccesos_Secuserid( A6SecUserId );
      obj35.setgxTv_SdtLogAccesos_Secusername( A14SecUserName );
      obj35.setgxTv_SdtLogAccesos_Secroleid( A4SecRoleId );
      obj35.setgxTv_SdtLogAccesos_Secroledescription( A12SecRoleDescription );
      obj35.setgxTv_SdtLogAccesos_Logaccesostipo( A227LogAccesosTipo );
      obj35.setgxTv_SdtLogAccesos_Logaccesosfecha( A228LogAccesosFecha );
      obj35.setgxTv_SdtLogAccesos_Logaccesosid( A41LogAccesosId );
      obj35.setgxTv_SdtLogAccesos_Logaccesosid_Z( Z41LogAccesosId );
      obj35.setgxTv_SdtLogAccesos_Secuserid_Z( Z6SecUserId );
      obj35.setgxTv_SdtLogAccesos_Secusername_Z( Z14SecUserName );
      obj35.setgxTv_SdtLogAccesos_Secroleid_Z( Z4SecRoleId );
      obj35.setgxTv_SdtLogAccesos_Secroledescription_Z( Z12SecRoleDescription );
      obj35.setgxTv_SdtLogAccesos_Logaccesosfullname_Z( Z172LogAccesosFullName );
      obj35.setgxTv_SdtLogAccesos_Logaccesostipo_Z( Z227LogAccesosTipo );
      obj35.setgxTv_SdtLogAccesos_Logaccesosfecha_Z( Z228LogAccesosFecha );
      obj35.setgxTv_SdtLogAccesos_Mode( Gx_mode );
   }

   public void KeyVarsToRow35( com.projectthani.SdtLogAccesos obj35 )
   {
      obj35.setgxTv_SdtLogAccesos_Logaccesosid( A41LogAccesosId );
   }

   public void RowToVars35( com.projectthani.SdtLogAccesos obj35 ,
                            int forceLoad )
   {
      Gx_mode = obj35.getgxTv_SdtLogAccesos_Mode() ;
      A172LogAccesosFullName = obj35.getgxTv_SdtLogAccesos_Logaccesosfullname() ;
      A6SecUserId = obj35.getgxTv_SdtLogAccesos_Secuserid() ;
      A14SecUserName = obj35.getgxTv_SdtLogAccesos_Secusername() ;
      A4SecRoleId = obj35.getgxTv_SdtLogAccesos_Secroleid() ;
      A12SecRoleDescription = obj35.getgxTv_SdtLogAccesos_Secroledescription() ;
      A227LogAccesosTipo = obj35.getgxTv_SdtLogAccesos_Logaccesostipo() ;
      A228LogAccesosFecha = obj35.getgxTv_SdtLogAccesos_Logaccesosfecha() ;
      A41LogAccesosId = obj35.getgxTv_SdtLogAccesos_Logaccesosid() ;
      Z41LogAccesosId = obj35.getgxTv_SdtLogAccesos_Logaccesosid_Z() ;
      Z6SecUserId = obj35.getgxTv_SdtLogAccesos_Secuserid_Z() ;
      Z14SecUserName = obj35.getgxTv_SdtLogAccesos_Secusername_Z() ;
      Z4SecRoleId = obj35.getgxTv_SdtLogAccesos_Secroleid_Z() ;
      Z12SecRoleDescription = obj35.getgxTv_SdtLogAccesos_Secroledescription_Z() ;
      Z172LogAccesosFullName = obj35.getgxTv_SdtLogAccesos_Logaccesosfullname_Z() ;
      Z227LogAccesosTipo = obj35.getgxTv_SdtLogAccesos_Logaccesostipo_Z() ;
      Z228LogAccesosFecha = obj35.getgxTv_SdtLogAccesos_Logaccesosfecha_Z() ;
      Gx_mode = obj35.getgxTv_SdtLogAccesos_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A41LogAccesosId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.SHORT)).shortValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey0Q35( ) ;
      scanKeyStart0Q35( ) ;
      if ( RcdFound35 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z41LogAccesosId = A41LogAccesosId ;
      }
      zm0Q35( -6) ;
      onLoadActions0Q35( ) ;
      addRow0Q35( ) ;
      scanKeyEnd0Q35( ) ;
      if ( RcdFound35 == 0 )
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
      RowToVars35( bcLogAccesos, 0) ;
      scanKeyStart0Q35( ) ;
      if ( RcdFound35 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z41LogAccesosId = A41LogAccesosId ;
      }
      zm0Q35( -6) ;
      onLoadActions0Q35( ) ;
      addRow0Q35( ) ;
      scanKeyEnd0Q35( ) ;
      if ( RcdFound35 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0Q35( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert0Q35( ) ;
      }
      else
      {
         if ( RcdFound35 == 1 )
         {
            if ( A41LogAccesosId != Z41LogAccesosId )
            {
               A41LogAccesosId = Z41LogAccesosId ;
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
               update0Q35( ) ;
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
               if ( A41LogAccesosId != Z41LogAccesosId )
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
                     insert0Q35( ) ;
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
                     insert0Q35( ) ;
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
      RowToVars35( bcLogAccesos, 1) ;
      saveImpl( ) ;
      VarsToRow35( bcLogAccesos) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars35( bcLogAccesos, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0Q35( ) ;
      afterTrn( ) ;
      VarsToRow35( bcLogAccesos) ;
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
         com.projectthani.SdtLogAccesos auxBC = new com.projectthani.SdtLogAccesos( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A41LogAccesosId);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcLogAccesos);
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
      RowToVars35( bcLogAccesos, 1) ;
      updateImpl( ) ;
      VarsToRow35( bcLogAccesos) ;
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
      RowToVars35( bcLogAccesos, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0Q35( ) ;
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
      VarsToRow35( bcLogAccesos) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars35( bcLogAccesos, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey0Q35( ) ;
      if ( RcdFound35 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( A41LogAccesosId != Z41LogAccesosId )
         {
            A41LogAccesosId = Z41LogAccesosId ;
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
         if ( A41LogAccesosId != Z41LogAccesosId )
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
      pr_default.close(15);
      pr_default.close(2);
      pr_default.close(16);
      pr_default.close(3);
      pr_default.close(4);
      Application.rollbackDataStores(context, remoteHandle, pr_default, "logaccesos_bc");
      VarsToRow35( bcLogAccesos) ;
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
      Gx_mode = bcLogAccesos.getgxTv_SdtLogAccesos_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcLogAccesos.setgxTv_SdtLogAccesos_Mode( Gx_mode );
   }

   public void SetSDT( com.projectthani.SdtLogAccesos sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcLogAccesos )
      {
         bcLogAccesos = sdt ;
         if ( GXutil.strcmp(bcLogAccesos.getgxTv_SdtLogAccesos_Mode(), "") == 0 )
         {
            bcLogAccesos.setgxTv_SdtLogAccesos_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow35( bcLogAccesos) ;
         }
         else
         {
            RowToVars35( bcLogAccesos, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcLogAccesos.getgxTv_SdtLogAccesos_Mode(), "") == 0 )
         {
            bcLogAccesos.setgxTv_SdtLogAccesos_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars35( bcLogAccesos, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtLogAccesos getLogAccesos_BC( )
   {
      return bcLogAccesos ;
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
      AV8WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV25Pgmname = "" ;
      AV11TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV12WebSession = httpContext.getWebSession();
      AV14TrnContextAtt = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      Z227LogAccesosTipo = "" ;
      A227LogAccesosTipo = "" ;
      Z228LogAccesosFecha = GXutil.resetTime( GXutil.nullDate() );
      A228LogAccesosFecha = GXutil.resetTime( GXutil.nullDate() );
      Z172LogAccesosFullName = "" ;
      A172LogAccesosFullName = "" ;
      Z14SecUserName = "" ;
      A14SecUserName = "" ;
      Z12SecRoleDescription = "" ;
      A12SecRoleDescription = "" ;
      BC000Q7_A41LogAccesosId = new short[1] ;
      BC000Q7_A14SecUserName = new String[] {""} ;
      BC000Q7_A12SecRoleDescription = new String[] {""} ;
      BC000Q7_A227LogAccesosTipo = new String[] {""} ;
      BC000Q7_A228LogAccesosFecha = new java.util.Date[] {GXutil.nullDate()} ;
      BC000Q7_A6SecUserId = new short[1] ;
      BC000Q7_A4SecRoleId = new short[1] ;
      BC000Q8_A14SecUserName = new String[] {""} ;
      BC000Q9_A6SecUserId = new short[1] ;
      BC000Q10_A12SecRoleDescription = new String[] {""} ;
      BC000Q11_A41LogAccesosId = new short[1] ;
      BC000Q12_A41LogAccesosId = new short[1] ;
      BC000Q12_A227LogAccesosTipo = new String[] {""} ;
      BC000Q12_A228LogAccesosFecha = new java.util.Date[] {GXutil.nullDate()} ;
      BC000Q12_A6SecUserId = new short[1] ;
      BC000Q12_A4SecRoleId = new short[1] ;
      sMode35 = "" ;
      BC000Q13_A41LogAccesosId = new short[1] ;
      BC000Q13_A227LogAccesosTipo = new String[] {""} ;
      BC000Q13_A228LogAccesosFecha = new java.util.Date[] {GXutil.nullDate()} ;
      BC000Q13_A6SecUserId = new short[1] ;
      BC000Q13_A4SecRoleId = new short[1] ;
      BC000Q14_A41LogAccesosId = new short[1] ;
      BC000Q17_A14SecUserName = new String[] {""} ;
      BC000Q18_A12SecRoleDescription = new String[] {""} ;
      GXt_char4 = "" ;
      GXv_char5 = new String[1] ;
      BC000Q19_A41LogAccesosId = new short[1] ;
      BC000Q19_A14SecUserName = new String[] {""} ;
      BC000Q19_A12SecRoleDescription = new String[] {""} ;
      BC000Q19_A227LogAccesosTipo = new String[] {""} ;
      BC000Q19_A228LogAccesosFecha = new java.util.Date[] {GXutil.nullDate()} ;
      BC000Q19_A6SecUserId = new short[1] ;
      BC000Q19_A4SecRoleId = new short[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.logaccesos_bc__default(),
         new Object[] {
             new Object[] {
            BC000Q2_A41LogAccesosId, BC000Q2_A227LogAccesosTipo, BC000Q2_A228LogAccesosFecha, BC000Q2_A6SecUserId, BC000Q2_A4SecRoleId
            }
            , new Object[] {
            BC000Q3_A41LogAccesosId, BC000Q3_A227LogAccesosTipo, BC000Q3_A228LogAccesosFecha, BC000Q3_A6SecUserId, BC000Q3_A4SecRoleId
            }
            , new Object[] {
            BC000Q4_A14SecUserName
            }
            , new Object[] {
            BC000Q5_A12SecRoleDescription
            }
            , new Object[] {
            BC000Q6_A6SecUserId
            }
            , new Object[] {
            BC000Q7_A41LogAccesosId, BC000Q7_A14SecUserName, BC000Q7_A12SecRoleDescription, BC000Q7_A227LogAccesosTipo, BC000Q7_A228LogAccesosFecha, BC000Q7_A6SecUserId, BC000Q7_A4SecRoleId
            }
            , new Object[] {
            BC000Q8_A14SecUserName
            }
            , new Object[] {
            BC000Q9_A6SecUserId
            }
            , new Object[] {
            BC000Q10_A12SecRoleDescription
            }
            , new Object[] {
            BC000Q11_A41LogAccesosId
            }
            , new Object[] {
            BC000Q12_A41LogAccesosId, BC000Q12_A227LogAccesosTipo, BC000Q12_A228LogAccesosFecha, BC000Q12_A6SecUserId, BC000Q12_A4SecRoleId
            }
            , new Object[] {
            BC000Q13_A41LogAccesosId, BC000Q13_A227LogAccesosTipo, BC000Q13_A228LogAccesosFecha, BC000Q13_A6SecUserId, BC000Q13_A4SecRoleId
            }
            , new Object[] {
            BC000Q14_A41LogAccesosId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000Q17_A14SecUserName
            }
            , new Object[] {
            BC000Q18_A12SecRoleDescription
            }
            , new Object[] {
            BC000Q19_A41LogAccesosId, BC000Q19_A14SecUserName, BC000Q19_A12SecRoleDescription, BC000Q19_A227LogAccesosTipo, BC000Q19_A228LogAccesosFecha, BC000Q19_A6SecUserId, BC000Q19_A4SecRoleId
            }
         }
      );
      AV25Pgmname = "LogAccesos_BC" ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e120Q2 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z41LogAccesosId ;
   private short A41LogAccesosId ;
   private short AV13Insert_SecUserId ;
   private short AV15Insert_SecRoleId ;
   private short Z6SecUserId ;
   private short A6SecUserId ;
   private short Z4SecRoleId ;
   private short A4SecRoleId ;
   private short RcdFound35 ;
   private short nIsDirty_35 ;
   private int trnEnded ;
   private int AV26GXV1 ;
   private int GX_JID ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String AV25Pgmname ;
   private String Z227LogAccesosTipo ;
   private String A227LogAccesosTipo ;
   private String sMode35 ;
   private String GXt_char4 ;
   private String GXv_char5[] ;
   private java.util.Date Z228LogAccesosFecha ;
   private java.util.Date A228LogAccesosFecha ;
   private boolean returnInSub ;
   private boolean AV9IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean mustCommit ;
   private String Z172LogAccesosFullName ;
   private String A172LogAccesosFullName ;
   private String Z14SecUserName ;
   private String A14SecUserName ;
   private String Z12SecRoleDescription ;
   private String A12SecRoleDescription ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV12WebSession ;
   private com.projectthani.SdtLogAccesos bcLogAccesos ;
   private IDataStoreProvider pr_default ;
   private short[] BC000Q7_A41LogAccesosId ;
   private String[] BC000Q7_A14SecUserName ;
   private String[] BC000Q7_A12SecRoleDescription ;
   private String[] BC000Q7_A227LogAccesosTipo ;
   private java.util.Date[] BC000Q7_A228LogAccesosFecha ;
   private short[] BC000Q7_A6SecUserId ;
   private short[] BC000Q7_A4SecRoleId ;
   private String[] BC000Q8_A14SecUserName ;
   private short[] BC000Q9_A6SecUserId ;
   private String[] BC000Q10_A12SecRoleDescription ;
   private short[] BC000Q11_A41LogAccesosId ;
   private short[] BC000Q12_A41LogAccesosId ;
   private String[] BC000Q12_A227LogAccesosTipo ;
   private java.util.Date[] BC000Q12_A228LogAccesosFecha ;
   private short[] BC000Q12_A6SecUserId ;
   private short[] BC000Q12_A4SecRoleId ;
   private short[] BC000Q13_A41LogAccesosId ;
   private String[] BC000Q13_A227LogAccesosTipo ;
   private java.util.Date[] BC000Q13_A228LogAccesosFecha ;
   private short[] BC000Q13_A6SecUserId ;
   private short[] BC000Q13_A4SecRoleId ;
   private short[] BC000Q14_A41LogAccesosId ;
   private String[] BC000Q17_A14SecUserName ;
   private String[] BC000Q18_A12SecRoleDescription ;
   private short[] BC000Q19_A41LogAccesosId ;
   private String[] BC000Q19_A14SecUserName ;
   private String[] BC000Q19_A12SecRoleDescription ;
   private String[] BC000Q19_A227LogAccesosTipo ;
   private java.util.Date[] BC000Q19_A228LogAccesosFecha ;
   private short[] BC000Q19_A6SecUserId ;
   private short[] BC000Q19_A4SecRoleId ;
   private short[] BC000Q2_A41LogAccesosId ;
   private String[] BC000Q2_A227LogAccesosTipo ;
   private java.util.Date[] BC000Q2_A228LogAccesosFecha ;
   private short[] BC000Q2_A6SecUserId ;
   private short[] BC000Q2_A4SecRoleId ;
   private short[] BC000Q3_A41LogAccesosId ;
   private String[] BC000Q3_A227LogAccesosTipo ;
   private java.util.Date[] BC000Q3_A228LogAccesosFecha ;
   private short[] BC000Q3_A6SecUserId ;
   private short[] BC000Q3_A4SecRoleId ;
   private String[] BC000Q4_A14SecUserName ;
   private String[] BC000Q5_A12SecRoleDescription ;
   private short[] BC000Q6_A6SecUserId ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV11TrnContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV14TrnContextAtt ;
}

final  class logaccesos_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC000Q2", "SELECT [LogAccesosId], [LogAccesosTipo], [LogAccesosFecha], [SecUserId], [SecRoleId] FROM [LogAccesos] WITH (UPDLOCK) WHERE [LogAccesosId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Q3", "SELECT [LogAccesosId], [LogAccesosTipo], [LogAccesosFecha], [SecUserId], [SecRoleId] FROM [LogAccesos] WHERE [LogAccesosId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Q4", "SELECT [SecUserName] FROM [SecUser] WHERE [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Q5", "SELECT [SecRoleDescription] FROM [SecRole] WHERE [SecRoleId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Q6", "SELECT [SecUserId] FROM [SecUserRole] WHERE [SecUserId] = ? AND [SecRoleId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Q7", "SELECT TM1.[LogAccesosId], T2.[SecUserName], T3.[SecRoleDescription], TM1.[LogAccesosTipo], TM1.[LogAccesosFecha], TM1.[SecUserId], TM1.[SecRoleId] FROM (([LogAccesos] TM1 INNER JOIN [SecUser] T2 ON T2.[SecUserId] = TM1.[SecUserId]) INNER JOIN [SecRole] T3 ON T3.[SecRoleId] = TM1.[SecRoleId]) WHERE TM1.[LogAccesosId] = ? ORDER BY TM1.[LogAccesosId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Q8", "SELECT [SecUserName] FROM [SecUser] WHERE [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Q9", "SELECT [SecUserId] FROM [SecUserRole] WHERE [SecUserId] = ? AND [SecRoleId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Q10", "SELECT [SecRoleDescription] FROM [SecRole] WHERE [SecRoleId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Q11", "SELECT [LogAccesosId] FROM [LogAccesos] WHERE [LogAccesosId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Q12", "SELECT [LogAccesosId], [LogAccesosTipo], [LogAccesosFecha], [SecUserId], [SecRoleId] FROM [LogAccesos] WHERE [LogAccesosId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Q13", "SELECT [LogAccesosId], [LogAccesosTipo], [LogAccesosFecha], [SecUserId], [SecRoleId] FROM [LogAccesos] WITH (UPDLOCK) WHERE [LogAccesosId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Q14", "INSERT INTO [LogAccesos]([LogAccesosTipo], [LogAccesosFecha], [SecUserId], [SecRoleId]) VALUES(?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("BC000Q15", "UPDATE [LogAccesos] SET [LogAccesosTipo]=?, [LogAccesosFecha]=?, [SecUserId]=?, [SecRoleId]=?  WHERE [LogAccesosId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC000Q16", "DELETE FROM [LogAccesos]  WHERE [LogAccesosId] = ?", GX_NOMASK)
         ,new ForEachCursor("BC000Q17", "SELECT [SecUserName] FROM [SecUser] WHERE [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Q18", "SELECT [SecRoleDescription] FROM [SecRole] WHERE [SecRoleId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Q19", "SELECT TM1.[LogAccesosId], T2.[SecUserName], T3.[SecRoleDescription], TM1.[LogAccesosTipo], TM1.[LogAccesosFecha], TM1.[SecUserId], TM1.[SecRoleId] FROM (([LogAccesos] TM1 INNER JOIN [SecUser] T2 ON T2.[SecUserId] = TM1.[SecUserId]) INNER JOIN [SecRole] T3 ON T3.[SecRoleId] = TM1.[SecRoleId]) WHERE TM1.[LogAccesosId] = ? ORDER BY TM1.[LogAccesosId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDateTime(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDateTime(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDateTime(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 8 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 9 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 10 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDateTime(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 11 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDateTime(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 12 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 15 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 16 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 17 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDateTime(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 6 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 7 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 8 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 9 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 10 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 11 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 12 :
               stmt.setString(1, (String)parms[0], 1);
               stmt.setDateTime(2, (java.util.Date)parms[1], false);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 13 :
               stmt.setString(1, (String)parms[0], 1);
               stmt.setDateTime(2, (java.util.Date)parms[1], false);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 14 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 15 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 16 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 17 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

