package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.search.*;
import java.sql.*;

public final  class asecupdatefuncionalities extends GXProcedure
{
   public static void main( String args[] )
   {
      Application.init(com.projectthani.GXcfg.class);
      asecupdatefuncionalities pgm = new asecupdatefuncionalities (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXRuntime.exit( );
   }

   public void executeCmdLine( String args[] )
   {

      execute();
   }

   public asecupdatefuncionalities( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( asecupdatefuncionalities.class ), "" );
   }

   public asecupdatefuncionalities( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( )
   {
      execute_int();
   }

   private void execute_int( )
   {
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV16RoleName = "Administrator" ;
      AV17AdminUserName = "Administrator" ;
      System.out.println( GXutil.format( "Administrator role: '%1'", AV16RoleName, "", "", "", "", "", "", "", "") );
      /* Optimized DELETE. */
      /* Using cursor P00282 */
      pr_default.execute(0);
      Application.getSmartCacheProvider(remoteHandle).setUpdated("SecObjectFunctionalities");
      /* End optimized DELETE. */
      /* Optimized DELETE. */
      /* Using cursor P00283 */
      pr_default.execute(1);
      Application.getSmartCacheProvider(remoteHandle).setUpdated("SecObject");
      /* End optimized DELETE. */
      /* Optimized UPDATE. */
      /* Using cursor P00284 */
      pr_default.execute(2);
      Application.getSmartCacheProvider(remoteHandle).setUpdated("SecFunctionality");
      /* End optimized UPDATE. */
      Application.commitDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.asecupdatefuncionalities");
      GXt_objcol_SdtSecFunctionalitiesToLoad1 = AV8SecFunctionalitiesToLoadCollection ;
      GXv_objcol_SdtSecFunctionalitiesToLoad2[0] = GXt_objcol_SdtSecFunctionalitiesToLoad1 ;
      new com.projectthani.wwpbaseobjects.secgetadvancedsecuritywwpfunctionalities(remoteHandle, context).execute( GXv_objcol_SdtSecFunctionalitiesToLoad2) ;
      GXt_objcol_SdtSecFunctionalitiesToLoad1 = GXv_objcol_SdtSecFunctionalitiesToLoad2[0] ;
      AV8SecFunctionalitiesToLoadCollection = GXt_objcol_SdtSecFunctionalitiesToLoad1 ;
      AV24GXV1 = 1 ;
      while ( AV24GXV1 <= AV8SecFunctionalitiesToLoadCollection.size() )
      {
         AV13SecFunctionalitiesToLoad = (com.projectthani.wwpbaseobjects.SdtSecFunctionalitiesToLoad)((com.projectthani.wwpbaseobjects.SdtSecFunctionalitiesToLoad)AV8SecFunctionalitiesToLoadCollection.elementAt(-1+AV24GXV1));
         AV25GXV2 = 1 ;
         while ( AV25GXV2 <= AV13SecFunctionalitiesToLoad.getgxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitykeys().size() )
         {
            AV11SecFunctionalityKey = (com.projectthani.wwpbaseobjects.SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem)((com.projectthani.wwpbaseobjects.SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem)AV13SecFunctionalitiesToLoad.getgxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitykeys().elementAt(-1+AV25GXV2));
            AV26GXLvl36 = (byte)(0) ;
            /* Optimized UPDATE. */
            /* Using cursor P00285 */
            pr_default.execute(3, new Object[] {AV11SecFunctionalityKey.getgxTv_SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem_Secfunctionalitykey()});
            if ( (pr_default.getStatus(3) != 101) )
            {
               AV26GXLvl36 = (byte)(1) ;
            }
            Application.getSmartCacheProvider(remoteHandle).setUpdated("SecFunctionality");
            /* End optimized UPDATE. */
            if ( AV26GXLvl36 == 0 )
            {
               System.out.println( GXutil.format( "Adding functionality '%1'...", AV11SecFunctionalityKey.getgxTv_SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem_Secfunctionalitykey(), "", "", "", "", "", "", "", "") );
               /*
                  INSERT RECORD ON TABLE SecFunctionality

               */
               A3SecFunctionalityKey = AV11SecFunctionalityKey.getgxTv_SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem_Secfunctionalitykey() ;
               A8SecFunctionalityDescription = AV11SecFunctionalityKey.getgxTv_SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem_Secfunctionalitydsc() ;
               A2SecParentFunctionalityId = 0 ;
               n2SecParentFunctionalityId = false ;
               n2SecParentFunctionalityId = true ;
               A7SecFunctionalityActive = true ;
               A9SecFunctionalityType = (byte)(0) ;
               /* Using cursor P00286 */
               pr_default.execute(4, new Object[] {A3SecFunctionalityKey, A8SecFunctionalityDescription, Byte.valueOf(A9SecFunctionalityType), Boolean.valueOf(n2SecParentFunctionalityId), Long.valueOf(A2SecParentFunctionalityId), Boolean.valueOf(A7SecFunctionalityActive)});
               A1SecFunctionalityId = P00286_A1SecFunctionalityId[0] ;
               Application.getSmartCacheProvider(remoteHandle).setUpdated("SecFunctionality");
               if ( (pr_default.getStatus(4) == 1) )
               {
                  Gx_err = (short)(1) ;
                  Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
               }
               else
               {
                  Gx_err = (short)(0) ;
                  Gx_emsg = "" ;
               }
               /* End Insert */
            }
            AV25GXV2 = (int)(AV25GXV2+1) ;
         }
         AV24GXV1 = (int)(AV24GXV1+1) ;
      }
      /* Using cursor P00287 */
      pr_default.execute(5);
      while ( (pr_default.getStatus(5) != 101) )
      {
         A1SecFunctionalityId = P00287_A1SecFunctionalityId[0] ;
         A3SecFunctionalityKey = P00287_A3SecFunctionalityKey[0] ;
         A7SecFunctionalityActive = P00287_A7SecFunctionalityActive[0] ;
         /* Using cursor P00288 */
         pr_default.execute(6, new Object[] {Long.valueOf(A1SecFunctionalityId)});
         while ( (pr_default.getStatus(6) != 101) )
         {
            A4SecRoleId = P00288_A4SecRoleId[0] ;
            A13SecRoleName = P00288_A13SecRoleName[0] ;
            A13SecRoleName = P00288_A13SecRoleName[0] ;
            System.out.println( GXutil.format( "Deleting functionality '%1' from role '%2'...", A3SecFunctionalityKey, A13SecRoleName, "", "", "", "", "", "", "") );
            /* Using cursor P00289 */
            pr_default.execute(7, new Object[] {Long.valueOf(A1SecFunctionalityId), Short.valueOf(A4SecRoleId)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("SecFunctionalityRole");
            pr_default.readNext(6);
         }
         pr_default.close(6);
         System.out.println( GXutil.format( "Deleting functionality '%1'...", A3SecFunctionalityKey, "", "", "", "", "", "", "", "") );
         /* Using cursor P002810 */
         pr_default.execute(8, new Object[] {Long.valueOf(A1SecFunctionalityId)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("SecFunctionality");
         pr_default.readNext(5);
      }
      pr_default.close(5);
      AV29GXV3 = 1 ;
      while ( AV29GXV3 <= AV8SecFunctionalitiesToLoadCollection.size() )
      {
         AV13SecFunctionalitiesToLoad = (com.projectthani.wwpbaseobjects.SdtSecFunctionalitiesToLoad)((com.projectthani.wwpbaseobjects.SdtSecFunctionalitiesToLoad)AV8SecFunctionalitiesToLoadCollection.elementAt(-1+AV29GXV3));
         AV30GXV4 = 1 ;
         while ( AV30GXV4 <= AV13SecFunctionalitiesToLoad.getgxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitykeys().size() )
         {
            AV11SecFunctionalityKey = (com.projectthani.wwpbaseobjects.SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem)((com.projectthani.wwpbaseobjects.SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem)AV13SecFunctionalitiesToLoad.getgxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitykeys().elementAt(-1+AV30GXV4));
            /* Using cursor P002811 */
            pr_default.execute(9, new Object[] {AV11SecFunctionalityKey.getgxTv_SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem_Secfunctionalitykey()});
            while ( (pr_default.getStatus(9) != 101) )
            {
               A3SecFunctionalityKey = P002811_A3SecFunctionalityKey[0] ;
               A8SecFunctionalityDescription = P002811_A8SecFunctionalityDescription[0] ;
               A9SecFunctionalityType = P002811_A9SecFunctionalityType[0] ;
               A2SecParentFunctionalityId = P002811_A2SecParentFunctionalityId[0] ;
               n2SecParentFunctionalityId = P002811_n2SecParentFunctionalityId[0] ;
               A7SecFunctionalityActive = P002811_A7SecFunctionalityActive[0] ;
               A1SecFunctionalityId = P002811_A1SecFunctionalityId[0] ;
               A8SecFunctionalityDescription = AV11SecFunctionalityKey.getgxTv_SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem_Secfunctionalitydsc() ;
               if ( (0==A9SecFunctionalityType) )
               {
                  A9SecFunctionalityType = AV13SecFunctionalitiesToLoad.getgxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitytype() ;
               }
               else
               {
                  if ( A9SecFunctionalityType != AV13SecFunctionalitiesToLoad.getgxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitytype() )
                  {
                     A9SecFunctionalityType = (byte)(4) ;
                     A2SecParentFunctionalityId = 0 ;
                     n2SecParentFunctionalityId = false ;
                     n2SecParentFunctionalityId = true ;
                  }
               }
               if ( ( A9SecFunctionalityType != 4 ) && ! (GXutil.strcmp("", AV13SecFunctionalitiesToLoad.getgxTv_SdtSecFunctionalitiesToLoad_Secparentfunctionalitykey())==0) )
               {
                  AV12SecFunctionalityKeyToFilter = AV13SecFunctionalitiesToLoad.getgxTv_SdtSecFunctionalitiesToLoad_Secparentfunctionalitykey() ;
                  /* Execute user subroutine: 'GETFUNCTIONALITYIDBYKEY' */
                  S111 ();
                  if ( returnInSub )
                  {
                     pr_default.close(9);
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
                  if ( A2SecParentFunctionalityId != AV9SecFunctionalityId )
                  {
                     if ( P002811_n2SecParentFunctionalityId[0] && ( ! (0==AV9SecFunctionalityId) ) && A7SecFunctionalityActive )
                     {
                        A2SecParentFunctionalityId = AV9SecFunctionalityId ;
                        n2SecParentFunctionalityId = false ;
                     }
                     else
                     {
                        A7SecFunctionalityActive = false ;
                        A2SecParentFunctionalityId = 0 ;
                        n2SecParentFunctionalityId = false ;
                        n2SecParentFunctionalityId = true ;
                     }
                  }
               }
               /* Using cursor P002812 */
               pr_default.execute(10, new Object[] {A8SecFunctionalityDescription, Byte.valueOf(A9SecFunctionalityType), Boolean.valueOf(n2SecParentFunctionalityId), Long.valueOf(A2SecParentFunctionalityId), Boolean.valueOf(A7SecFunctionalityActive), Long.valueOf(A1SecFunctionalityId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("SecFunctionality");
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(9);
            AV30GXV4 = (int)(AV30GXV4+1) ;
         }
         AV29GXV3 = (int)(AV29GXV3+1) ;
      }
      /* Optimized UPDATE. */
      /* Using cursor P002813 */
      pr_default.execute(11);
      Application.getSmartCacheProvider(remoteHandle).setUpdated("SecFunctionality");
      /* End optimized UPDATE. */
      AV33GXV5 = 1 ;
      while ( AV33GXV5 <= AV8SecFunctionalitiesToLoadCollection.size() )
      {
         AV13SecFunctionalitiesToLoad = (com.projectthani.wwpbaseobjects.SdtSecFunctionalitiesToLoad)((com.projectthani.wwpbaseobjects.SdtSecFunctionalitiesToLoad)AV8SecFunctionalitiesToLoadCollection.elementAt(-1+AV33GXV5));
         if ( ! (GXutil.strcmp("", AV13SecFunctionalitiesToLoad.getgxTv_SdtSecFunctionalitiesToLoad_Secobjectname())==0) )
         {
            /*
               INSERT RECORD ON TABLE SecObject

            */
            A5SecObjectName = GXutil.trim( GXutil.lower( AV13SecFunctionalitiesToLoad.getgxTv_SdtSecFunctionalitiesToLoad_Secobjectname())) ;
            /* Using cursor P002814 */
            pr_default.execute(12, new Object[] {A5SecObjectName});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("SecObject");
            if ( (pr_default.getStatus(12) == 1) )
            {
               Gx_err = (short)(1) ;
               Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
            }
            else
            {
               Gx_err = (short)(0) ;
               Gx_emsg = "" ;
            }
            /* End Insert */
            AV34GXV6 = 1 ;
            while ( AV34GXV6 <= AV13SecFunctionalitiesToLoad.getgxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitykeys().size() )
            {
               AV11SecFunctionalityKey = (com.projectthani.wwpbaseobjects.SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem)((com.projectthani.wwpbaseobjects.SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem)AV13SecFunctionalitiesToLoad.getgxTv_SdtSecFunctionalitiesToLoad_Secfunctionalitykeys().elementAt(-1+AV34GXV6));
               AV12SecFunctionalityKeyToFilter = AV11SecFunctionalityKey.getgxTv_SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem_Secfunctionalitykey() ;
               /* Execute user subroutine: 'GETFUNCTIONALITYIDBYKEY' */
               S111 ();
               if ( returnInSub )
               {
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               if ( ! (0==AV9SecFunctionalityId) )
               {
                  /*
                     INSERT RECORD ON TABLE SecObjectFunctionalities

                  */
                  A5SecObjectName = GXutil.trim( GXutil.lower( AV13SecFunctionalitiesToLoad.getgxTv_SdtSecFunctionalitiesToLoad_Secobjectname())) ;
                  A1SecFunctionalityId = AV9SecFunctionalityId ;
                  /* Using cursor P002815 */
                  pr_default.execute(13, new Object[] {A5SecObjectName, Long.valueOf(A1SecFunctionalityId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("SecObjectFunctionalities");
                  if ( (pr_default.getStatus(13) == 1) )
                  {
                     Gx_err = (short)(1) ;
                     Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
                  }
                  else
                  {
                     Gx_err = (short)(0) ;
                     Gx_emsg = "" ;
                  }
                  /* End Insert */
               }
               AV34GXV6 = (int)(AV34GXV6+1) ;
            }
         }
         AV33GXV5 = (int)(AV33GXV5+1) ;
      }
      Application.commitDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.asecupdatefuncionalities");
      if ( GXutil.strcmp(AV16RoleName, "") != 0 )
      {
         if ( GXutil.strcmp(AV17AdminUserName, "") != 0 )
         {
            AV18AssignRoleToUser = true ;
         }
         else
         {
            AV18AssignRoleToUser = false ;
         }
         new com.projectthani.wwpbaseobjects.secgrantallaccesstoadminrole(remoteHandle, context).execute( AV16RoleName, AV18AssignRoleToUser, AV17AdminUserName) ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'GETFUNCTIONALITYIDBYKEY' Routine */
      returnInSub = false ;
      /* Using cursor P002817 */
      pr_default.execute(14, new Object[] {AV12SecFunctionalityKeyToFilter});
      if ( (pr_default.getStatus(14) != 101) )
      {
         A40000SecFunctionalityId = P002817_A40000SecFunctionalityId[0] ;
         n40000SecFunctionalityId = P002817_n40000SecFunctionalityId[0] ;
      }
      else
      {
         A40000SecFunctionalityId = 0 ;
         n40000SecFunctionalityId = false ;
      }
      pr_default.close(14);
      AV9SecFunctionalityId = A40000SecFunctionalityId ;
      if ( (0==AV9SecFunctionalityId) )
      {
         System.out.println( GXutil.format( "Functionality '%1' not found", AV12SecFunctionalityKeyToFilter, "", "", "", "", "", "", "", "") );
      }
   }

   public static Object refClasses( )
   {
      GXutil.refClasses(secupdatefuncionalities.class);
      return new com.projectthani.GXcfg();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.asecupdatefuncionalities");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV16RoleName = "" ;
      AV17AdminUserName = "" ;
      AV8SecFunctionalitiesToLoadCollection = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtSecFunctionalitiesToLoad>(com.projectthani.wwpbaseobjects.SdtSecFunctionalitiesToLoad.class, "SecFunctionalitiesToLoad", "ProjectThani", remoteHandle);
      GXt_objcol_SdtSecFunctionalitiesToLoad1 = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtSecFunctionalitiesToLoad>(com.projectthani.wwpbaseobjects.SdtSecFunctionalitiesToLoad.class, "SecFunctionalitiesToLoad", "ProjectThani", remoteHandle);
      GXv_objcol_SdtSecFunctionalitiesToLoad2 = new GXBaseCollection[1] ;
      AV13SecFunctionalitiesToLoad = new com.projectthani.wwpbaseobjects.SdtSecFunctionalitiesToLoad(remoteHandle, context);
      AV11SecFunctionalityKey = new com.projectthani.wwpbaseobjects.SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem(remoteHandle, context);
      A3SecFunctionalityKey = "" ;
      A8SecFunctionalityDescription = "" ;
      P00286_A1SecFunctionalityId = new long[1] ;
      Gx_emsg = "" ;
      scmdbuf = "" ;
      P00287_A1SecFunctionalityId = new long[1] ;
      P00287_A3SecFunctionalityKey = new String[] {""} ;
      P00287_A7SecFunctionalityActive = new boolean[] {false} ;
      P00288_A1SecFunctionalityId = new long[1] ;
      P00288_A4SecRoleId = new short[1] ;
      P00288_A13SecRoleName = new String[] {""} ;
      A13SecRoleName = "" ;
      P002811_A3SecFunctionalityKey = new String[] {""} ;
      P002811_A8SecFunctionalityDescription = new String[] {""} ;
      P002811_A9SecFunctionalityType = new byte[1] ;
      P002811_A2SecParentFunctionalityId = new long[1] ;
      P002811_n2SecParentFunctionalityId = new boolean[] {false} ;
      P002811_A7SecFunctionalityActive = new boolean[] {false} ;
      P002811_A1SecFunctionalityId = new long[1] ;
      AV12SecFunctionalityKeyToFilter = "" ;
      A5SecObjectName = "" ;
      P002817_A40000SecFunctionalityId = new long[1] ;
      P002817_n40000SecFunctionalityId = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wwpbaseobjects.asecupdatefuncionalities__default(),
         new Object[] {
             new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            P00286_A1SecFunctionalityId
            }
            , new Object[] {
            P00287_A1SecFunctionalityId, P00287_A3SecFunctionalityKey, P00287_A7SecFunctionalityActive
            }
            , new Object[] {
            P00288_A1SecFunctionalityId, P00288_A4SecRoleId, P00288_A13SecRoleName
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            P002811_A3SecFunctionalityKey, P002811_A8SecFunctionalityDescription, P002811_A9SecFunctionalityType, P002811_A2SecParentFunctionalityId, P002811_n2SecParentFunctionalityId, P002811_A7SecFunctionalityActive, P002811_A1SecFunctionalityId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            P002817_A40000SecFunctionalityId, P002817_n40000SecFunctionalityId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV26GXLvl36 ;
   private byte A9SecFunctionalityType ;
   private short Gx_err ;
   private short A4SecRoleId ;
   private int AV24GXV1 ;
   private int AV25GXV2 ;
   private int GX_INS1 ;
   private int AV29GXV3 ;
   private int AV30GXV4 ;
   private int AV33GXV5 ;
   private int GX_INS3 ;
   private int AV34GXV6 ;
   private int GX_INS4 ;
   private long A2SecParentFunctionalityId ;
   private long A1SecFunctionalityId ;
   private long AV9SecFunctionalityId ;
   private long A40000SecFunctionalityId ;
   private String Gx_emsg ;
   private String scmdbuf ;
   private boolean n2SecParentFunctionalityId ;
   private boolean A7SecFunctionalityActive ;
   private boolean returnInSub ;
   private boolean AV18AssignRoleToUser ;
   private boolean n40000SecFunctionalityId ;
   private String AV16RoleName ;
   private String AV17AdminUserName ;
   private String A3SecFunctionalityKey ;
   private String A8SecFunctionalityDescription ;
   private String A13SecRoleName ;
   private String AV12SecFunctionalityKeyToFilter ;
   private String A5SecObjectName ;
   private IDataStoreProvider pr_default ;
   private long[] P00286_A1SecFunctionalityId ;
   private long[] P00287_A1SecFunctionalityId ;
   private String[] P00287_A3SecFunctionalityKey ;
   private boolean[] P00287_A7SecFunctionalityActive ;
   private long[] P00288_A1SecFunctionalityId ;
   private short[] P00288_A4SecRoleId ;
   private String[] P00288_A13SecRoleName ;
   private String[] P002811_A3SecFunctionalityKey ;
   private String[] P002811_A8SecFunctionalityDescription ;
   private byte[] P002811_A9SecFunctionalityType ;
   private long[] P002811_A2SecParentFunctionalityId ;
   private boolean[] P002811_n2SecParentFunctionalityId ;
   private boolean[] P002811_A7SecFunctionalityActive ;
   private long[] P002811_A1SecFunctionalityId ;
   private long[] P002817_A40000SecFunctionalityId ;
   private boolean[] P002817_n40000SecFunctionalityId ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtSecFunctionalitiesToLoad> AV8SecFunctionalitiesToLoadCollection ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtSecFunctionalitiesToLoad> GXt_objcol_SdtSecFunctionalitiesToLoad1 ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtSecFunctionalitiesToLoad> GXv_objcol_SdtSecFunctionalitiesToLoad2[] ;
   private com.projectthani.wwpbaseobjects.SdtSecFunctionalitiesToLoad AV13SecFunctionalitiesToLoad ;
   private com.projectthani.wwpbaseobjects.SdtSecFunctionalitiesToLoad_SecFunctionalityKeysItem AV11SecFunctionalityKey ;
}

final  class asecupdatefuncionalities__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P00282", "DELETE FROM [SecObjectFunctionalities] ", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P00283", "DELETE FROM [SecObject] ", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P00284", "UPDATE [SecFunctionality] SET [SecParentFunctionalityId]=NULL, [SecFunctionalityActive]=CONVERT(BIT, 0) ", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P00285", "UPDATE [SecFunctionality] SET [SecFunctionalityType]=convert(int, 0), [SecFunctionalityActive]=CONVERT(BIT, 1), [SecParentFunctionalityId]=NULL  WHERE [SecFunctionalityKey] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P00286", "INSERT INTO [SecFunctionality]([SecFunctionalityKey], [SecFunctionalityDescription], [SecFunctionalityType], [SecParentFunctionalityId], [SecFunctionalityActive]) VALUES(?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P00287", "SELECT [SecFunctionalityId], [SecFunctionalityKey], [SecFunctionalityActive] FROM [SecFunctionality] WITH (UPDLOCK) WHERE [SecFunctionalityActive] = 0 ORDER BY [SecFunctionalityId] ",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00288", "SELECT T1.[SecFunctionalityId], T1.[SecRoleId], T2.[SecRoleName] FROM ([SecFunctionalityRole] T1 WITH (UPDLOCK) INNER JOIN [SecRole] T2 ON T2.[SecRoleId] = T1.[SecRoleId]) WHERE T1.[SecFunctionalityId] = ? ORDER BY T1.[SecFunctionalityId] ",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P00289", "DELETE FROM [SecFunctionalityRole]  WHERE [SecFunctionalityId] = ? AND [SecRoleId] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P002810", "DELETE FROM [SecFunctionality]  WHERE [SecFunctionalityId] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P002811", "SELECT [SecFunctionalityKey], [SecFunctionalityDescription], [SecFunctionalityType], [SecParentFunctionalityId], [SecFunctionalityActive], [SecFunctionalityId] FROM [SecFunctionality] WITH (UPDLOCK) WHERE [SecFunctionalityKey] = ? ORDER BY [SecFunctionalityKey] ",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P002812", "UPDATE [SecFunctionality] SET [SecFunctionalityDescription]=?, [SecFunctionalityType]=?, [SecParentFunctionalityId]=?, [SecFunctionalityActive]=?  WHERE [SecFunctionalityId] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P002813", "UPDATE [SecFunctionality] SET [SecFunctionalityActive]=CONVERT(BIT, 1)  WHERE [SecFunctionalityActive] = 0", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P002814", "INSERT INTO [SecObject]([SecObjectName]) VALUES(?)", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P002815", "INSERT INTO [SecObjectFunctionalities]([SecObjectName], [SecFunctionalityId]) VALUES(?, ?)", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P002817", "SELECT COALESCE( T1.[SecFunctionalityId], 0) AS SecFunctionalityId FROM (SELECT [SecFunctionalityId] AS SecFunctionalityId, [SecFunctionalityKey] FROM [SecFunctionality] WHERE [SecFunctionalityKey] = ? ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 4 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 5 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               return;
            case 6 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 9 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((boolean[]) buf[5])[0] = rslt.getBoolean(5);
               ((long[]) buf[6])[0] = rslt.getLong(6);
               return;
            case 14 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 3 :
               stmt.setVarchar(1, (String)parms[0], 100);
               return;
            case 4 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setVarchar(2, (String)parms[1], 100, false);
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(4, ((Number) parms[4]).longValue());
               }
               stmt.setBoolean(5, ((Boolean) parms[5]).booleanValue());
               return;
            case 6 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 7 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 8 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 9 :
               stmt.setVarchar(1, (String)parms[0], 100);
               return;
            case 10 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(3, ((Number) parms[3]).longValue());
               }
               stmt.setBoolean(4, ((Boolean) parms[4]).booleanValue());
               stmt.setLong(5, ((Number) parms[5]).longValue());
               return;
            case 12 :
               stmt.setVarchar(1, (String)parms[0], 120, false);
               return;
            case 13 :
               stmt.setVarchar(1, (String)parms[0], 120, false);
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 14 :
               stmt.setVarchar(1, (String)parms[0], 100);
               return;
      }
   }

}

