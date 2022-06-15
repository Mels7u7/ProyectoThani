package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class usercustomizations_bc extends GXWebPanel implements IGxSilentTrn
{
   public usercustomizations_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public usercustomizations_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( usercustomizations_bc.class ));
   }

   public usercustomizations_bc( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow078( ) ;
      standaloneNotModal( ) ;
      initializeNonKey078( ) ;
      standaloneModal( ) ;
      addRow078( ) ;
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
            Z16UserCustomizationsId = A16UserCustomizationsId ;
            Z17UserCustomizationsKey = A17UserCustomizationsKey ;
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

   public void confirm_070( )
   {
      beforeValidate078( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls078( ) ;
         }
         else
         {
            checkExtendedTable078( ) ;
            if ( AnyError == 0 )
            {
            }
            closeExtendedTableCursors078( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void zm078( int GX_JID )
   {
      if ( ( GX_JID == 1 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -1 )
      {
         Z16UserCustomizationsId = A16UserCustomizationsId ;
         Z17UserCustomizationsKey = A17UserCustomizationsKey ;
         Z18UserCustomizationsValue = A18UserCustomizationsValue ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
   }

   public void load078( )
   {
      /* Using cursor BC00074 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A16UserCustomizationsId), A17UserCustomizationsKey});
      if ( (pr_default.getStatus(2) != 101) )
      {
         RcdFound8 = (short)(1) ;
         A18UserCustomizationsValue = BC00074_A18UserCustomizationsValue[0] ;
         zm078( -1) ;
      }
      pr_default.close(2);
      onLoadActions078( ) ;
   }

   public void onLoadActions078( )
   {
   }

   public void checkExtendedTable078( )
   {
      nIsDirty_8 = (short)(0) ;
      standaloneModal( ) ;
   }

   public void closeExtendedTableCursors078( )
   {
   }

   public void enableDisable( )
   {
   }

   public void getKey078( )
   {
      /* Using cursor BC00075 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A16UserCustomizationsId), A17UserCustomizationsKey});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound8 = (short)(1) ;
      }
      else
      {
         RcdFound8 = (short)(0) ;
      }
      pr_default.close(3);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC00076 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A16UserCustomizationsId), A17UserCustomizationsKey});
      if ( (pr_default.getStatus(4) != 101) )
      {
         zm078( 1) ;
         RcdFound8 = (short)(1) ;
         A16UserCustomizationsId = BC00076_A16UserCustomizationsId[0] ;
         A17UserCustomizationsKey = BC00076_A17UserCustomizationsKey[0] ;
         A18UserCustomizationsValue = BC00076_A18UserCustomizationsValue[0] ;
         Z16UserCustomizationsId = A16UserCustomizationsId ;
         Z17UserCustomizationsKey = A17UserCustomizationsKey ;
         sMode8 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load078( ) ;
         if ( AnyError == 1 )
         {
            RcdFound8 = (short)(0) ;
            initializeNonKey078( ) ;
         }
         Gx_mode = sMode8 ;
      }
      else
      {
         RcdFound8 = (short)(0) ;
         initializeNonKey078( ) ;
         sMode8 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode8 ;
      }
      pr_default.close(4);
   }

   public void getEqualNoModal( )
   {
      getKey078( ) ;
      if ( RcdFound8 == 0 )
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
      confirm_070( ) ;
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

   public void checkOptimisticConcurrency078( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC00077 */
         pr_default.execute(5, new Object[] {Integer.valueOf(A16UserCustomizationsId), A17UserCustomizationsKey});
         if ( (pr_default.getStatus(5) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"UserCustomizations"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(5) == 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"UserCustomizations"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert078( )
   {
      beforeValidate078( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable078( ) ;
      }
      if ( AnyError == 0 )
      {
         zm078( 0) ;
         checkOptimisticConcurrency078( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm078( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert078( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC00078 */
                  pr_default.execute(6, new Object[] {Integer.valueOf(A16UserCustomizationsId), A17UserCustomizationsKey, A18UserCustomizationsValue});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("UserCustomizations");
                  if ( (pr_default.getStatus(6) == 1) )
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
            load078( ) ;
         }
         endLevel078( ) ;
      }
      closeExtendedTableCursors078( ) ;
   }

   public void update078( )
   {
      beforeValidate078( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable078( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency078( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm078( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate078( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC00079 */
                  pr_default.execute(7, new Object[] {A18UserCustomizationsValue, Integer.valueOf(A16UserCustomizationsId), A17UserCustomizationsKey});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("UserCustomizations");
                  if ( (pr_default.getStatus(7) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"UserCustomizations"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate078( ) ;
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
         endLevel078( ) ;
      }
      closeExtendedTableCursors078( ) ;
   }

   public void deferredUpdate078( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate078( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency078( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls078( ) ;
         afterConfirm078( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete078( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000710 */
               pr_default.execute(8, new Object[] {Integer.valueOf(A16UserCustomizationsId), A17UserCustomizationsKey});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("UserCustomizations");
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
      sMode8 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel078( ) ;
      Gx_mode = sMode8 ;
   }

   public void onDeleteControls078( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel078( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(5);
      }
      if ( AnyError == 0 )
      {
         beforeComplete078( ) ;
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

   public void scanKeyStart078( )
   {
      /* Using cursor BC000711 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A16UserCustomizationsId), A17UserCustomizationsKey});
      RcdFound8 = (short)(0) ;
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound8 = (short)(1) ;
         A16UserCustomizationsId = BC000711_A16UserCustomizationsId[0] ;
         A17UserCustomizationsKey = BC000711_A17UserCustomizationsKey[0] ;
         A18UserCustomizationsValue = BC000711_A18UserCustomizationsValue[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext078( )
   {
      /* Scan next routine */
      pr_default.readNext(9);
      RcdFound8 = (short)(0) ;
      scanKeyLoad078( ) ;
   }

   public void scanKeyLoad078( )
   {
      sMode8 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound8 = (short)(1) ;
         A16UserCustomizationsId = BC000711_A16UserCustomizationsId[0] ;
         A17UserCustomizationsKey = BC000711_A17UserCustomizationsKey[0] ;
         A18UserCustomizationsValue = BC000711_A18UserCustomizationsValue[0] ;
      }
      Gx_mode = sMode8 ;
   }

   public void scanKeyEnd078( )
   {
      pr_default.close(9);
   }

   public void afterConfirm078( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert078( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate078( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete078( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete078( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate078( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes078( )
   {
   }

   public void send_integrity_lvl_hashes078( )
   {
   }

   public void addRow078( )
   {
      VarsToRow8( bcwwpbaseobjects_UserCustomizations) ;
   }

   public void readRow078( )
   {
      RowToVars8( bcwwpbaseobjects_UserCustomizations, 1) ;
   }

   public void initializeNonKey078( )
   {
      A18UserCustomizationsValue = "" ;
   }

   public void initAll078( )
   {
      A16UserCustomizationsId = 0 ;
      A17UserCustomizationsKey = "" ;
      initializeNonKey078( ) ;
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

   public void VarsToRow8( com.projectthani.wwpbaseobjects.SdtUserCustomizations obj8 )
   {
      obj8.setgxTv_SdtUserCustomizations_Mode( Gx_mode );
      obj8.setgxTv_SdtUserCustomizations_Usercustomizationsvalue( A18UserCustomizationsValue );
      obj8.setgxTv_SdtUserCustomizations_Usercustomizationsid( A16UserCustomizationsId );
      obj8.setgxTv_SdtUserCustomizations_Usercustomizationskey( A17UserCustomizationsKey );
      obj8.setgxTv_SdtUserCustomizations_Usercustomizationsid_Z( Z16UserCustomizationsId );
      obj8.setgxTv_SdtUserCustomizations_Usercustomizationskey_Z( Z17UserCustomizationsKey );
      obj8.setgxTv_SdtUserCustomizations_Mode( Gx_mode );
   }

   public void KeyVarsToRow8( com.projectthani.wwpbaseobjects.SdtUserCustomizations obj8 )
   {
      obj8.setgxTv_SdtUserCustomizations_Usercustomizationsid( A16UserCustomizationsId );
      obj8.setgxTv_SdtUserCustomizations_Usercustomizationskey( A17UserCustomizationsKey );
   }

   public void RowToVars8( com.projectthani.wwpbaseobjects.SdtUserCustomizations obj8 ,
                           int forceLoad )
   {
      Gx_mode = obj8.getgxTv_SdtUserCustomizations_Mode() ;
      A18UserCustomizationsValue = obj8.getgxTv_SdtUserCustomizations_Usercustomizationsvalue() ;
      A16UserCustomizationsId = obj8.getgxTv_SdtUserCustomizations_Usercustomizationsid() ;
      A17UserCustomizationsKey = obj8.getgxTv_SdtUserCustomizations_Usercustomizationskey() ;
      Z16UserCustomizationsId = obj8.getgxTv_SdtUserCustomizations_Usercustomizationsid_Z() ;
      Z17UserCustomizationsKey = obj8.getgxTv_SdtUserCustomizations_Usercustomizationskey_Z() ;
      Gx_mode = obj8.getgxTv_SdtUserCustomizations_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A16UserCustomizationsId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      A17UserCustomizationsKey = (String)getParm(obj,1) ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey078( ) ;
      scanKeyStart078( ) ;
      if ( RcdFound8 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z16UserCustomizationsId = A16UserCustomizationsId ;
         Z17UserCustomizationsKey = A17UserCustomizationsKey ;
      }
      zm078( -1) ;
      onLoadActions078( ) ;
      addRow078( ) ;
      scanKeyEnd078( ) ;
      if ( RcdFound8 == 0 )
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
      RowToVars8( bcwwpbaseobjects_UserCustomizations, 0) ;
      scanKeyStart078( ) ;
      if ( RcdFound8 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z16UserCustomizationsId = A16UserCustomizationsId ;
         Z17UserCustomizationsKey = A17UserCustomizationsKey ;
      }
      zm078( -1) ;
      onLoadActions078( ) ;
      addRow078( ) ;
      scanKeyEnd078( ) ;
      if ( RcdFound8 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey078( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert078( ) ;
      }
      else
      {
         if ( RcdFound8 == 1 )
         {
            if ( ( A16UserCustomizationsId != Z16UserCustomizationsId ) || ( GXutil.strcmp(A17UserCustomizationsKey, Z17UserCustomizationsKey) != 0 ) )
            {
               A16UserCustomizationsId = Z16UserCustomizationsId ;
               A17UserCustomizationsKey = Z17UserCustomizationsKey ;
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
               update078( ) ;
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
               if ( ( A16UserCustomizationsId != Z16UserCustomizationsId ) || ( GXutil.strcmp(A17UserCustomizationsKey, Z17UserCustomizationsKey) != 0 ) )
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
                     insert078( ) ;
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
                     insert078( ) ;
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
      RowToVars8( bcwwpbaseobjects_UserCustomizations, 1) ;
      saveImpl( ) ;
      VarsToRow8( bcwwpbaseobjects_UserCustomizations) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars8( bcwwpbaseobjects_UserCustomizations, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert078( ) ;
      afterTrn( ) ;
      VarsToRow8( bcwwpbaseobjects_UserCustomizations) ;
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
         com.projectthani.wwpbaseobjects.SdtUserCustomizations auxBC = new com.projectthani.wwpbaseobjects.SdtUserCustomizations( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A16UserCustomizationsId, A17UserCustomizationsKey);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcwwpbaseobjects_UserCustomizations);
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
      RowToVars8( bcwwpbaseobjects_UserCustomizations, 1) ;
      updateImpl( ) ;
      VarsToRow8( bcwwpbaseobjects_UserCustomizations) ;
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
      RowToVars8( bcwwpbaseobjects_UserCustomizations, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert078( ) ;
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
      VarsToRow8( bcwwpbaseobjects_UserCustomizations) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars8( bcwwpbaseobjects_UserCustomizations, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey078( ) ;
      if ( RcdFound8 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( ( A16UserCustomizationsId != Z16UserCustomizationsId ) || ( GXutil.strcmp(A17UserCustomizationsKey, Z17UserCustomizationsKey) != 0 ) )
         {
            A16UserCustomizationsId = Z16UserCustomizationsId ;
            A17UserCustomizationsKey = Z17UserCustomizationsKey ;
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
         if ( ( A16UserCustomizationsId != Z16UserCustomizationsId ) || ( GXutil.strcmp(A17UserCustomizationsKey, Z17UserCustomizationsKey) != 0 ) )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.usercustomizations_bc");
      VarsToRow8( bcwwpbaseobjects_UserCustomizations) ;
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
      Gx_mode = bcwwpbaseobjects_UserCustomizations.getgxTv_SdtUserCustomizations_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcwwpbaseobjects_UserCustomizations.setgxTv_SdtUserCustomizations_Mode( Gx_mode );
   }

   public void SetSDT( com.projectthani.wwpbaseobjects.SdtUserCustomizations sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcwwpbaseobjects_UserCustomizations )
      {
         bcwwpbaseobjects_UserCustomizations = sdt ;
         if ( GXutil.strcmp(bcwwpbaseobjects_UserCustomizations.getgxTv_SdtUserCustomizations_Mode(), "") == 0 )
         {
            bcwwpbaseobjects_UserCustomizations.setgxTv_SdtUserCustomizations_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow8( bcwwpbaseobjects_UserCustomizations) ;
         }
         else
         {
            RowToVars8( bcwwpbaseobjects_UserCustomizations, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcwwpbaseobjects_UserCustomizations.getgxTv_SdtUserCustomizations_Mode(), "") == 0 )
         {
            bcwwpbaseobjects_UserCustomizations.setgxTv_SdtUserCustomizations_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars8( bcwwpbaseobjects_UserCustomizations, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtUserCustomizations getUserCustomizations_BC( )
   {
      return bcwwpbaseobjects_UserCustomizations ;
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
      Z17UserCustomizationsKey = "" ;
      A17UserCustomizationsKey = "" ;
      Z18UserCustomizationsValue = "" ;
      A18UserCustomizationsValue = "" ;
      BC00074_A16UserCustomizationsId = new int[1] ;
      BC00074_A17UserCustomizationsKey = new String[] {""} ;
      BC00074_A18UserCustomizationsValue = new String[] {""} ;
      BC00075_A16UserCustomizationsId = new int[1] ;
      BC00075_A17UserCustomizationsKey = new String[] {""} ;
      BC00076_A16UserCustomizationsId = new int[1] ;
      BC00076_A17UserCustomizationsKey = new String[] {""} ;
      BC00076_A18UserCustomizationsValue = new String[] {""} ;
      sMode8 = "" ;
      BC00077_A16UserCustomizationsId = new int[1] ;
      BC00077_A17UserCustomizationsKey = new String[] {""} ;
      BC00077_A18UserCustomizationsValue = new String[] {""} ;
      BC000711_A16UserCustomizationsId = new int[1] ;
      BC000711_A17UserCustomizationsKey = new String[] {""} ;
      BC000711_A18UserCustomizationsValue = new String[] {""} ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wwpbaseobjects.usercustomizations_bc__default(),
         new Object[] {
             new Object[] {
            BC00072_A16UserCustomizationsId, BC00072_A17UserCustomizationsKey, BC00072_A18UserCustomizationsValue
            }
            , new Object[] {
            BC00073_A16UserCustomizationsId, BC00073_A17UserCustomizationsKey, BC00073_A18UserCustomizationsValue
            }
            , new Object[] {
            BC00074_A16UserCustomizationsId, BC00074_A17UserCustomizationsKey, BC00074_A18UserCustomizationsValue
            }
            , new Object[] {
            BC00075_A16UserCustomizationsId, BC00075_A17UserCustomizationsKey
            }
            , new Object[] {
            BC00076_A16UserCustomizationsId, BC00076_A17UserCustomizationsKey, BC00076_A18UserCustomizationsValue
            }
            , new Object[] {
            BC00077_A16UserCustomizationsId, BC00077_A17UserCustomizationsKey, BC00077_A18UserCustomizationsValue
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000711_A16UserCustomizationsId, BC000711_A17UserCustomizationsKey, BC000711_A18UserCustomizationsValue
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
   private short RcdFound8 ;
   private short nIsDirty_8 ;
   private int trnEnded ;
   private int Z16UserCustomizationsId ;
   private int A16UserCustomizationsId ;
   private int GX_JID ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sMode8 ;
   private boolean mustCommit ;
   private String Z18UserCustomizationsValue ;
   private String A18UserCustomizationsValue ;
   private String Z17UserCustomizationsKey ;
   private String A17UserCustomizationsKey ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.projectthani.wwpbaseobjects.SdtUserCustomizations bcwwpbaseobjects_UserCustomizations ;
   private IDataStoreProvider pr_default ;
   private int[] BC00074_A16UserCustomizationsId ;
   private String[] BC00074_A17UserCustomizationsKey ;
   private String[] BC00074_A18UserCustomizationsValue ;
   private int[] BC00075_A16UserCustomizationsId ;
   private String[] BC00075_A17UserCustomizationsKey ;
   private int[] BC00076_A16UserCustomizationsId ;
   private String[] BC00076_A17UserCustomizationsKey ;
   private String[] BC00076_A18UserCustomizationsValue ;
   private int[] BC00077_A16UserCustomizationsId ;
   private String[] BC00077_A17UserCustomizationsKey ;
   private String[] BC00077_A18UserCustomizationsValue ;
   private int[] BC000711_A16UserCustomizationsId ;
   private String[] BC000711_A17UserCustomizationsKey ;
   private String[] BC000711_A18UserCustomizationsValue ;
   private int[] BC00072_A16UserCustomizationsId ;
   private String[] BC00072_A17UserCustomizationsKey ;
   private String[] BC00072_A18UserCustomizationsValue ;
   private int[] BC00073_A16UserCustomizationsId ;
   private String[] BC00073_A17UserCustomizationsKey ;
   private String[] BC00073_A18UserCustomizationsValue ;
}

final  class usercustomizations_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC00072", "SELECT [UserCustomizationsId], [UserCustomizationsKey], [UserCustomizationsValue] FROM [UserCustomizations] WITH (UPDLOCK) WHERE [UserCustomizationsId] = ? AND [UserCustomizationsKey] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00073", "SELECT [UserCustomizationsId], [UserCustomizationsKey], [UserCustomizationsValue] FROM [UserCustomizations] WHERE [UserCustomizationsId] = ? AND [UserCustomizationsKey] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00074", "SELECT TM1.[UserCustomizationsId], TM1.[UserCustomizationsKey], TM1.[UserCustomizationsValue] FROM [UserCustomizations] TM1 WHERE TM1.[UserCustomizationsId] = ? and TM1.[UserCustomizationsKey] = ? ORDER BY TM1.[UserCustomizationsId], TM1.[UserCustomizationsKey]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00075", "SELECT [UserCustomizationsId], [UserCustomizationsKey] FROM [UserCustomizations] WHERE [UserCustomizationsId] = ? AND [UserCustomizationsKey] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00076", "SELECT [UserCustomizationsId], [UserCustomizationsKey], [UserCustomizationsValue] FROM [UserCustomizations] WHERE [UserCustomizationsId] = ? AND [UserCustomizationsKey] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00077", "SELECT [UserCustomizationsId], [UserCustomizationsKey], [UserCustomizationsValue] FROM [UserCustomizations] WITH (UPDLOCK) WHERE [UserCustomizationsId] = ? AND [UserCustomizationsKey] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC00078", "INSERT INTO [UserCustomizations]([UserCustomizationsId], [UserCustomizationsKey], [UserCustomizationsValue]) VALUES(?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("BC00079", "UPDATE [UserCustomizations] SET [UserCustomizationsValue]=?  WHERE [UserCustomizationsId] = ? AND [UserCustomizationsKey] = ?", GX_NOMASK)
         ,new UpdateCursor("BC000710", "DELETE FROM [UserCustomizations]  WHERE [UserCustomizationsId] = ? AND [UserCustomizationsKey] = ?", GX_NOMASK)
         ,new ForEachCursor("BC000711", "SELECT TM1.[UserCustomizationsId], TM1.[UserCustomizationsKey], TM1.[UserCustomizationsValue] FROM [UserCustomizations] TM1 WHERE TM1.[UserCustomizationsId] = ? and TM1.[UserCustomizationsKey] = ? ORDER BY TM1.[UserCustomizationsId], TM1.[UserCustomizationsKey]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setVarchar(2, (String)parms[1], 200, false);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setVarchar(2, (String)parms[1], 200, false);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setVarchar(2, (String)parms[1], 200, false);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setVarchar(2, (String)parms[1], 200, false);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setVarchar(2, (String)parms[1], 200, false);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setVarchar(2, (String)parms[1], 200, false);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setVarchar(2, (String)parms[1], 200, false);
               stmt.setNLongVarchar(3, (String)parms[2], false);
               return;
            case 7 :
               stmt.setNLongVarchar(1, (String)parms[0], false);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setVarchar(3, (String)parms[2], 200, false);
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setVarchar(2, (String)parms[1], 200, false);
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setVarchar(2, (String)parms[1], 200, false);
               return;
      }
   }

}

