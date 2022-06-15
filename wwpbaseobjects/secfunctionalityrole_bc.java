package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class secfunctionalityrole_bc extends GXWebPanel implements IGxSilentTrn
{
   public secfunctionalityrole_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public secfunctionalityrole_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( secfunctionalityrole_bc.class ));
   }

   public secfunctionalityrole_bc( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow022( ) ;
      standaloneNotModal( ) ;
      initializeNonKey022( ) ;
      standaloneModal( ) ;
      addRow022( ) ;
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
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z1SecFunctionalityId = A1SecFunctionalityId ;
            Z4SecRoleId = A4SecRoleId ;
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

   public void confirm_020( )
   {
      beforeValidate022( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls022( ) ;
         }
         else
         {
            checkExtendedTable022( ) ;
            if ( AnyError == 0 )
            {
               zm022( 2) ;
               zm022( 3) ;
            }
            closeExtendedTableCursors022( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void zm022( int GX_JID )
   {
      if ( ( GX_JID == 1 ) || ( GX_JID == 0 ) )
      {
      }
      if ( ( GX_JID == 2 ) || ( GX_JID == 0 ) )
      {
         Z8SecFunctionalityDescription = A8SecFunctionalityDescription ;
      }
      if ( ( GX_JID == 3 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -1 )
      {
         Z1SecFunctionalityId = A1SecFunctionalityId ;
         Z4SecRoleId = A4SecRoleId ;
         Z8SecFunctionalityDescription = A8SecFunctionalityDescription ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
   }

   public void load022( )
   {
      /* Using cursor BC00026 */
      pr_default.execute(4, new Object[] {Long.valueOf(A1SecFunctionalityId), Short.valueOf(A4SecRoleId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound2 = (short)(1) ;
         A8SecFunctionalityDescription = BC00026_A8SecFunctionalityDescription[0] ;
         zm022( -1) ;
      }
      pr_default.close(4);
      onLoadActions022( ) ;
   }

   public void onLoadActions022( )
   {
   }

   public void checkExtendedTable022( )
   {
      nIsDirty_2 = (short)(0) ;
      standaloneModal( ) ;
      /* Using cursor BC00027 */
      pr_default.execute(5, new Object[] {Long.valueOf(A1SecFunctionalityId)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Functionality'.", "ForeignKeyNotFound", 1, "SECFUNCTIONALITYID");
         AnyError = (short)(1) ;
      }
      A8SecFunctionalityDescription = BC00027_A8SecFunctionalityDescription[0] ;
      pr_default.close(5);
      /* Using cursor BC00028 */
      pr_default.execute(6, new Object[] {Short.valueOf(A4SecRoleId)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Role'.", "ForeignKeyNotFound", 1, "SECROLEID");
         AnyError = (short)(1) ;
      }
      pr_default.close(6);
   }

   public void closeExtendedTableCursors022( )
   {
      pr_default.close(5);
      pr_default.close(6);
   }

   public void enableDisable( )
   {
   }

   public void getKey022( )
   {
      /* Using cursor BC00029 */
      pr_default.execute(7, new Object[] {Long.valueOf(A1SecFunctionalityId), Short.valueOf(A4SecRoleId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound2 = (short)(1) ;
      }
      else
      {
         RcdFound2 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC000210 */
      pr_default.execute(8, new Object[] {Long.valueOf(A1SecFunctionalityId), Short.valueOf(A4SecRoleId)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         zm022( 1) ;
         RcdFound2 = (short)(1) ;
         A1SecFunctionalityId = BC000210_A1SecFunctionalityId[0] ;
         A4SecRoleId = BC000210_A4SecRoleId[0] ;
         Z1SecFunctionalityId = A1SecFunctionalityId ;
         Z4SecRoleId = A4SecRoleId ;
         sMode2 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load022( ) ;
         if ( AnyError == 1 )
         {
            RcdFound2 = (short)(0) ;
            initializeNonKey022( ) ;
         }
         Gx_mode = sMode2 ;
      }
      else
      {
         RcdFound2 = (short)(0) ;
         initializeNonKey022( ) ;
         sMode2 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode2 ;
      }
      pr_default.close(8);
   }

   public void getEqualNoModal( )
   {
      getKey022( ) ;
      if ( RcdFound2 == 0 )
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
      confirm_020( ) ;
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

   public void checkOptimisticConcurrency022( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000211 */
         pr_default.execute(9, new Object[] {Long.valueOf(A1SecFunctionalityId), Short.valueOf(A4SecRoleId)});
         if ( (pr_default.getStatus(9) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"SecFunctionalityRole"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(9) == 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"SecFunctionalityRole"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert022( )
   {
      beforeValidate022( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable022( ) ;
      }
      if ( AnyError == 0 )
      {
         zm022( 0) ;
         checkOptimisticConcurrency022( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm022( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert022( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000212 */
                  pr_default.execute(10, new Object[] {Long.valueOf(A1SecFunctionalityId), Short.valueOf(A4SecRoleId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("SecFunctionalityRole");
                  if ( (pr_default.getStatus(10) == 1) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
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
            load022( ) ;
         }
         endLevel022( ) ;
      }
      closeExtendedTableCursors022( ) ;
   }

   public void update022( )
   {
      beforeValidate022( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable022( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency022( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm022( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate022( ) ;
               if ( AnyError == 0 )
               {
                  /* No attributes to update on table [SecFunctionalityRole] */
                  deferredUpdate022( ) ;
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
         endLevel022( ) ;
      }
      closeExtendedTableCursors022( ) ;
   }

   public void deferredUpdate022( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate022( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency022( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls022( ) ;
         afterConfirm022( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete022( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000213 */
               pr_default.execute(11, new Object[] {Long.valueOf(A1SecFunctionalityId), Short.valueOf(A4SecRoleId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("SecFunctionalityRole");
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
      sMode2 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel022( ) ;
      Gx_mode = sMode2 ;
   }

   public void onDeleteControls022( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor BC000214 */
         pr_default.execute(12, new Object[] {Long.valueOf(A1SecFunctionalityId)});
         A8SecFunctionalityDescription = BC000214_A8SecFunctionalityDescription[0] ;
         pr_default.close(12);
      }
   }

   public void endLevel022( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(9);
      }
      if ( AnyError == 0 )
      {
         beforeComplete022( ) ;
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

   public void scanKeyStart022( )
   {
      /* Scan By routine */
      /* Using cursor BC000215 */
      pr_default.execute(13, new Object[] {Long.valueOf(A1SecFunctionalityId), Short.valueOf(A4SecRoleId)});
      RcdFound2 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound2 = (short)(1) ;
         A8SecFunctionalityDescription = BC000215_A8SecFunctionalityDescription[0] ;
         A1SecFunctionalityId = BC000215_A1SecFunctionalityId[0] ;
         A4SecRoleId = BC000215_A4SecRoleId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext022( )
   {
      /* Scan next routine */
      pr_default.readNext(13);
      RcdFound2 = (short)(0) ;
      scanKeyLoad022( ) ;
   }

   public void scanKeyLoad022( )
   {
      sMode2 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound2 = (short)(1) ;
         A8SecFunctionalityDescription = BC000215_A8SecFunctionalityDescription[0] ;
         A1SecFunctionalityId = BC000215_A1SecFunctionalityId[0] ;
         A4SecRoleId = BC000215_A4SecRoleId[0] ;
      }
      Gx_mode = sMode2 ;
   }

   public void scanKeyEnd022( )
   {
      pr_default.close(13);
   }

   public void afterConfirm022( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert022( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate022( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete022( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete022( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate022( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes022( )
   {
   }

   public void send_integrity_lvl_hashes022( )
   {
   }

   public void addRow022( )
   {
      VarsToRow2( bcwwpbaseobjects_SecFunctionalityRole) ;
   }

   public void readRow022( )
   {
      RowToVars2( bcwwpbaseobjects_SecFunctionalityRole, 1) ;
   }

   public void initializeNonKey022( )
   {
      A8SecFunctionalityDescription = "" ;
   }

   public void initAll022( )
   {
      A1SecFunctionalityId = 0 ;
      A4SecRoleId = (short)(0) ;
      initializeNonKey022( ) ;
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

   public void VarsToRow2( com.projectthani.wwpbaseobjects.SdtSecFunctionalityRole obj2 )
   {
      obj2.setgxTv_SdtSecFunctionalityRole_Mode( Gx_mode );
      obj2.setgxTv_SdtSecFunctionalityRole_Secfunctionalitydescription( A8SecFunctionalityDescription );
      obj2.setgxTv_SdtSecFunctionalityRole_Secfunctionalityid( A1SecFunctionalityId );
      obj2.setgxTv_SdtSecFunctionalityRole_Secroleid( A4SecRoleId );
      obj2.setgxTv_SdtSecFunctionalityRole_Secfunctionalityid_Z( Z1SecFunctionalityId );
      obj2.setgxTv_SdtSecFunctionalityRole_Secfunctionalitydescription_Z( Z8SecFunctionalityDescription );
      obj2.setgxTv_SdtSecFunctionalityRole_Secroleid_Z( Z4SecRoleId );
      obj2.setgxTv_SdtSecFunctionalityRole_Mode( Gx_mode );
   }

   public void KeyVarsToRow2( com.projectthani.wwpbaseobjects.SdtSecFunctionalityRole obj2 )
   {
      obj2.setgxTv_SdtSecFunctionalityRole_Secfunctionalityid( A1SecFunctionalityId );
      obj2.setgxTv_SdtSecFunctionalityRole_Secroleid( A4SecRoleId );
   }

   public void RowToVars2( com.projectthani.wwpbaseobjects.SdtSecFunctionalityRole obj2 ,
                           int forceLoad )
   {
      Gx_mode = obj2.getgxTv_SdtSecFunctionalityRole_Mode() ;
      A8SecFunctionalityDescription = obj2.getgxTv_SdtSecFunctionalityRole_Secfunctionalitydescription() ;
      A1SecFunctionalityId = obj2.getgxTv_SdtSecFunctionalityRole_Secfunctionalityid() ;
      A4SecRoleId = obj2.getgxTv_SdtSecFunctionalityRole_Secroleid() ;
      Z1SecFunctionalityId = obj2.getgxTv_SdtSecFunctionalityRole_Secfunctionalityid_Z() ;
      Z8SecFunctionalityDescription = obj2.getgxTv_SdtSecFunctionalityRole_Secfunctionalitydescription_Z() ;
      Z4SecRoleId = obj2.getgxTv_SdtSecFunctionalityRole_Secroleid_Z() ;
      Gx_mode = obj2.getgxTv_SdtSecFunctionalityRole_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A1SecFunctionalityId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.LONG)).longValue() ;
      A4SecRoleId = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.SHORT)).shortValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey022( ) ;
      scanKeyStart022( ) ;
      if ( RcdFound2 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC000216 */
         pr_default.execute(14, new Object[] {Long.valueOf(A1SecFunctionalityId)});
         if ( (pr_default.getStatus(14) == 101) )
         {
            httpContext.GX_msglist.addItem("No existe 'Functionality'.", "ForeignKeyNotFound", 1, "SECFUNCTIONALITYID");
            AnyError = (short)(1) ;
         }
         A8SecFunctionalityDescription = BC000216_A8SecFunctionalityDescription[0] ;
         pr_default.close(14);
         /* Using cursor BC000217 */
         pr_default.execute(15, new Object[] {Short.valueOf(A4SecRoleId)});
         if ( (pr_default.getStatus(15) == 101) )
         {
            httpContext.GX_msglist.addItem("No existe 'Role'.", "ForeignKeyNotFound", 1, "SECROLEID");
            AnyError = (short)(1) ;
         }
         pr_default.close(15);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z1SecFunctionalityId = A1SecFunctionalityId ;
         Z4SecRoleId = A4SecRoleId ;
      }
      zm022( -1) ;
      onLoadActions022( ) ;
      addRow022( ) ;
      scanKeyEnd022( ) ;
      if ( RcdFound2 == 0 )
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
      RowToVars2( bcwwpbaseobjects_SecFunctionalityRole, 0) ;
      scanKeyStart022( ) ;
      if ( RcdFound2 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC000218 */
         pr_default.execute(16, new Object[] {Long.valueOf(A1SecFunctionalityId)});
         if ( (pr_default.getStatus(16) == 101) )
         {
            httpContext.GX_msglist.addItem("No existe 'Functionality'.", "ForeignKeyNotFound", 1, "SECFUNCTIONALITYID");
            AnyError = (short)(1) ;
         }
         A8SecFunctionalityDescription = BC000218_A8SecFunctionalityDescription[0] ;
         pr_default.close(16);
         /* Using cursor BC000219 */
         pr_default.execute(17, new Object[] {Short.valueOf(A4SecRoleId)});
         if ( (pr_default.getStatus(17) == 101) )
         {
            httpContext.GX_msglist.addItem("No existe 'Role'.", "ForeignKeyNotFound", 1, "SECROLEID");
            AnyError = (short)(1) ;
         }
         pr_default.close(17);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z1SecFunctionalityId = A1SecFunctionalityId ;
         Z4SecRoleId = A4SecRoleId ;
      }
      zm022( -1) ;
      onLoadActions022( ) ;
      addRow022( ) ;
      scanKeyEnd022( ) ;
      if ( RcdFound2 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey022( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert022( ) ;
      }
      else
      {
         if ( RcdFound2 == 1 )
         {
            if ( ( A1SecFunctionalityId != Z1SecFunctionalityId ) || ( A4SecRoleId != Z4SecRoleId ) )
            {
               A1SecFunctionalityId = Z1SecFunctionalityId ;
               A4SecRoleId = Z4SecRoleId ;
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
               update022( ) ;
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
               if ( ( A1SecFunctionalityId != Z1SecFunctionalityId ) || ( A4SecRoleId != Z4SecRoleId ) )
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
                     insert022( ) ;
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
                     insert022( ) ;
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
      RowToVars2( bcwwpbaseobjects_SecFunctionalityRole, 1) ;
      saveImpl( ) ;
      VarsToRow2( bcwwpbaseobjects_SecFunctionalityRole) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars2( bcwwpbaseobjects_SecFunctionalityRole, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert022( ) ;
      afterTrn( ) ;
      VarsToRow2( bcwwpbaseobjects_SecFunctionalityRole) ;
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
         com.projectthani.wwpbaseobjects.SdtSecFunctionalityRole auxBC = new com.projectthani.wwpbaseobjects.SdtSecFunctionalityRole( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A1SecFunctionalityId, A4SecRoleId);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcwwpbaseobjects_SecFunctionalityRole);
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
      RowToVars2( bcwwpbaseobjects_SecFunctionalityRole, 1) ;
      updateImpl( ) ;
      VarsToRow2( bcwwpbaseobjects_SecFunctionalityRole) ;
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
      RowToVars2( bcwwpbaseobjects_SecFunctionalityRole, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert022( ) ;
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
      VarsToRow2( bcwwpbaseobjects_SecFunctionalityRole) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars2( bcwwpbaseobjects_SecFunctionalityRole, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey022( ) ;
      if ( RcdFound2 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( ( A1SecFunctionalityId != Z1SecFunctionalityId ) || ( A4SecRoleId != Z4SecRoleId ) )
         {
            A1SecFunctionalityId = Z1SecFunctionalityId ;
            A4SecRoleId = Z4SecRoleId ;
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
         if ( ( A1SecFunctionalityId != Z1SecFunctionalityId ) || ( A4SecRoleId != Z4SecRoleId ) )
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
      pr_default.close(16);
      pr_default.close(14);
      pr_default.close(12);
      pr_default.close(2);
      pr_default.close(17);
      pr_default.close(15);
      pr_default.close(3);
      Application.rollbackDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.secfunctionalityrole_bc");
      VarsToRow2( bcwwpbaseobjects_SecFunctionalityRole) ;
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
      Gx_mode = bcwwpbaseobjects_SecFunctionalityRole.getgxTv_SdtSecFunctionalityRole_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcwwpbaseobjects_SecFunctionalityRole.setgxTv_SdtSecFunctionalityRole_Mode( Gx_mode );
   }

   public void SetSDT( com.projectthani.wwpbaseobjects.SdtSecFunctionalityRole sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcwwpbaseobjects_SecFunctionalityRole )
      {
         bcwwpbaseobjects_SecFunctionalityRole = sdt ;
         if ( GXutil.strcmp(bcwwpbaseobjects_SecFunctionalityRole.getgxTv_SdtSecFunctionalityRole_Mode(), "") == 0 )
         {
            bcwwpbaseobjects_SecFunctionalityRole.setgxTv_SdtSecFunctionalityRole_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow2( bcwwpbaseobjects_SecFunctionalityRole) ;
         }
         else
         {
            RowToVars2( bcwwpbaseobjects_SecFunctionalityRole, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcwwpbaseobjects_SecFunctionalityRole.getgxTv_SdtSecFunctionalityRole_Mode(), "") == 0 )
         {
            bcwwpbaseobjects_SecFunctionalityRole.setgxTv_SdtSecFunctionalityRole_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars2( bcwwpbaseobjects_SecFunctionalityRole, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtSecFunctionalityRole getSecFunctionalityRole_BC( )
   {
      return bcwwpbaseobjects_SecFunctionalityRole ;
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
      Z8SecFunctionalityDescription = "" ;
      A8SecFunctionalityDescription = "" ;
      BC00026_A8SecFunctionalityDescription = new String[] {""} ;
      BC00026_A1SecFunctionalityId = new long[1] ;
      BC00026_A4SecRoleId = new short[1] ;
      BC00027_A8SecFunctionalityDescription = new String[] {""} ;
      BC00028_A4SecRoleId = new short[1] ;
      BC00029_A1SecFunctionalityId = new long[1] ;
      BC00029_A4SecRoleId = new short[1] ;
      BC000210_A1SecFunctionalityId = new long[1] ;
      BC000210_A4SecRoleId = new short[1] ;
      sMode2 = "" ;
      BC000211_A1SecFunctionalityId = new long[1] ;
      BC000211_A4SecRoleId = new short[1] ;
      BC000214_A8SecFunctionalityDescription = new String[] {""} ;
      BC000215_A8SecFunctionalityDescription = new String[] {""} ;
      BC000215_A1SecFunctionalityId = new long[1] ;
      BC000215_A4SecRoleId = new short[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      BC000216_A8SecFunctionalityDescription = new String[] {""} ;
      BC000217_A4SecRoleId = new short[1] ;
      BC000218_A8SecFunctionalityDescription = new String[] {""} ;
      BC000219_A4SecRoleId = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wwpbaseobjects.secfunctionalityrole_bc__default(),
         new Object[] {
             new Object[] {
            BC00022_A1SecFunctionalityId, BC00022_A4SecRoleId
            }
            , new Object[] {
            BC00023_A1SecFunctionalityId, BC00023_A4SecRoleId
            }
            , new Object[] {
            BC00024_A8SecFunctionalityDescription
            }
            , new Object[] {
            BC00025_A4SecRoleId
            }
            , new Object[] {
            BC00026_A8SecFunctionalityDescription, BC00026_A1SecFunctionalityId, BC00026_A4SecRoleId
            }
            , new Object[] {
            BC00027_A8SecFunctionalityDescription
            }
            , new Object[] {
            BC00028_A4SecRoleId
            }
            , new Object[] {
            BC00029_A1SecFunctionalityId, BC00029_A4SecRoleId
            }
            , new Object[] {
            BC000210_A1SecFunctionalityId, BC000210_A4SecRoleId
            }
            , new Object[] {
            BC000211_A1SecFunctionalityId, BC000211_A4SecRoleId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000214_A8SecFunctionalityDescription
            }
            , new Object[] {
            BC000215_A8SecFunctionalityDescription, BC000215_A1SecFunctionalityId, BC000215_A4SecRoleId
            }
            , new Object[] {
            BC000216_A8SecFunctionalityDescription
            }
            , new Object[] {
            BC000217_A4SecRoleId
            }
            , new Object[] {
            BC000218_A8SecFunctionalityDescription
            }
            , new Object[] {
            BC000219_A4SecRoleId
            }
         }
      );
      /* Execute Start event if defined. */
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z4SecRoleId ;
   private short A4SecRoleId ;
   private short RcdFound2 ;
   private short nIsDirty_2 ;
   private int trnEnded ;
   private int GX_JID ;
   private long Z1SecFunctionalityId ;
   private long A1SecFunctionalityId ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sMode2 ;
   private boolean mustCommit ;
   private String Z8SecFunctionalityDescription ;
   private String A8SecFunctionalityDescription ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.projectthani.wwpbaseobjects.SdtSecFunctionalityRole bcwwpbaseobjects_SecFunctionalityRole ;
   private IDataStoreProvider pr_default ;
   private String[] BC00026_A8SecFunctionalityDescription ;
   private long[] BC00026_A1SecFunctionalityId ;
   private short[] BC00026_A4SecRoleId ;
   private String[] BC00027_A8SecFunctionalityDescription ;
   private short[] BC00028_A4SecRoleId ;
   private long[] BC00029_A1SecFunctionalityId ;
   private short[] BC00029_A4SecRoleId ;
   private long[] BC000210_A1SecFunctionalityId ;
   private short[] BC000210_A4SecRoleId ;
   private long[] BC000211_A1SecFunctionalityId ;
   private short[] BC000211_A4SecRoleId ;
   private String[] BC000214_A8SecFunctionalityDescription ;
   private String[] BC000215_A8SecFunctionalityDescription ;
   private long[] BC000215_A1SecFunctionalityId ;
   private short[] BC000215_A4SecRoleId ;
   private String[] BC000216_A8SecFunctionalityDescription ;
   private short[] BC000217_A4SecRoleId ;
   private String[] BC000218_A8SecFunctionalityDescription ;
   private short[] BC000219_A4SecRoleId ;
   private long[] BC00022_A1SecFunctionalityId ;
   private short[] BC00022_A4SecRoleId ;
   private long[] BC00023_A1SecFunctionalityId ;
   private short[] BC00023_A4SecRoleId ;
   private String[] BC00024_A8SecFunctionalityDescription ;
   private short[] BC00025_A4SecRoleId ;
}

final  class secfunctionalityrole_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC00022", "SELECT [SecFunctionalityId], [SecRoleId] FROM [SecFunctionalityRole] WITH (UPDLOCK) WHERE [SecFunctionalityId] = ? AND [SecRoleId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00023", "SELECT [SecFunctionalityId], [SecRoleId] FROM [SecFunctionalityRole] WHERE [SecFunctionalityId] = ? AND [SecRoleId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00024", "SELECT [SecFunctionalityDescription] FROM [SecFunctionality] WHERE [SecFunctionalityId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00025", "SELECT [SecRoleId] FROM [SecRole] WHERE [SecRoleId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00026", "SELECT T2.[SecFunctionalityDescription], TM1.[SecFunctionalityId], TM1.[SecRoleId] FROM ([SecFunctionalityRole] TM1 INNER JOIN [SecFunctionality] T2 ON T2.[SecFunctionalityId] = TM1.[SecFunctionalityId]) WHERE TM1.[SecFunctionalityId] = ? and TM1.[SecRoleId] = ? ORDER BY TM1.[SecFunctionalityId], TM1.[SecRoleId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00027", "SELECT [SecFunctionalityDescription] FROM [SecFunctionality] WHERE [SecFunctionalityId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00028", "SELECT [SecRoleId] FROM [SecRole] WHERE [SecRoleId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00029", "SELECT [SecFunctionalityId], [SecRoleId] FROM [SecFunctionalityRole] WHERE [SecFunctionalityId] = ? AND [SecRoleId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000210", "SELECT [SecFunctionalityId], [SecRoleId] FROM [SecFunctionalityRole] WHERE [SecFunctionalityId] = ? AND [SecRoleId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000211", "SELECT [SecFunctionalityId], [SecRoleId] FROM [SecFunctionalityRole] WITH (UPDLOCK) WHERE [SecFunctionalityId] = ? AND [SecRoleId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000212", "INSERT INTO [SecFunctionalityRole]([SecFunctionalityId], [SecRoleId]) VALUES(?, ?)", GX_NOMASK)
         ,new UpdateCursor("BC000213", "DELETE FROM [SecFunctionalityRole]  WHERE [SecFunctionalityId] = ? AND [SecRoleId] = ?", GX_NOMASK)
         ,new ForEachCursor("BC000214", "SELECT [SecFunctionalityDescription] FROM [SecFunctionality] WHERE [SecFunctionalityId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000215", "SELECT T2.[SecFunctionalityDescription], TM1.[SecFunctionalityId], TM1.[SecRoleId] FROM ([SecFunctionalityRole] TM1 INNER JOIN [SecFunctionality] T2 ON T2.[SecFunctionalityId] = TM1.[SecFunctionalityId]) WHERE TM1.[SecFunctionalityId] = ? and TM1.[SecRoleId] = ? ORDER BY TM1.[SecFunctionalityId], TM1.[SecRoleId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000216", "SELECT [SecFunctionalityDescription] FROM [SecFunctionality] WHERE [SecFunctionalityId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000217", "SELECT [SecRoleId] FROM [SecRole] WHERE [SecRoleId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000218", "SELECT [SecFunctionalityDescription] FROM [SecFunctionality] WHERE [SecFunctionalityId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000219", "SELECT [SecRoleId] FROM [SecRole] WHERE [SecRoleId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 7 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 8 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 9 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 12 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 13 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 14 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 15 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 16 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 17 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
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
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 1 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 2 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 4 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 5 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 6 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 7 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 8 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 9 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 10 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 11 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 12 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 13 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 14 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 15 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 16 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 17 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

