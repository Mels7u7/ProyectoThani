package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcguardarmedicamentos extends GXProcedure
{
   public prcguardarmedicamentos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcguardarmedicamentos.class ), "" );
   }

   public prcguardarmedicamentos( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              GXBaseCollection<com.projectthani.SdtSDTMedicamentoGridItem> aP1 )
   {
      prcguardarmedicamentos.this.aP2 = new boolean[] {false};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        GXBaseCollection<com.projectthani.SdtSDTMedicamentoGridItem> aP1 ,
                        boolean[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             GXBaseCollection<com.projectthani.SdtSDTMedicamentoGridItem> aP1 ,
                             boolean[] aP2 )
   {
      prcguardarmedicamentos.this.AV8CitaId = aP0;
      prcguardarmedicamentos.this.AV10SDTMedicamentoItems = aP1;
      prcguardarmedicamentos.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV16GXV1 = 1 ;
      while ( AV16GXV1 <= AV10SDTMedicamentoItems.size() )
      {
         AV11SDTMedicamentoItem = (com.projectthani.SdtSDTMedicamentoGridItem)((com.projectthani.SdtSDTMedicamentoGridItem)AV10SDTMedicamentoItems.elementAt(-1+AV16GXV1));
         AV12isDuplicado = false ;
         /* Using cursor P007I2 */
         pr_default.execute(0, new Object[] {Short.valueOf(AV11SDTMedicamentoItem.getgxTv_SdtSDTMedicamentoGridItem_Medicamentoid()), Integer.valueOf(AV8CitaId)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A42MedicamentoId = P007I2_A42MedicamentoId[0] ;
            n42MedicamentoId = P007I2_n42MedicamentoId[0] ;
            A19CitaId = P007I2_A19CitaId[0] ;
            A50RecetaMedicaId = P007I2_A50RecetaMedicaId[0] ;
            AV12isDuplicado = true ;
            pr_default.readNext(0);
         }
         pr_default.close(0);
         if ( ! AV12isDuplicado )
         {
            /*
               INSERT RECORD ON TABLE RecetaMedica

            */
            A19CitaId = AV8CitaId ;
            A42MedicamentoId = AV11SDTMedicamentoItem.getgxTv_SdtSDTMedicamentoGridItem_Medicamentoid() ;
            n42MedicamentoId = false ;
            A269RecetaMedicaCantidad = AV11SDTMedicamentoItem.getgxTv_SdtSDTMedicamentoGridItem_Medicamentocantidad() ;
            n269RecetaMedicaCantidad = false ;
            A272RecetaMedicaFlag = (byte)(1) ;
            n272RecetaMedicaFlag = false ;
            A332RecetaIndicaciones = AV11SDTMedicamentoItem.getgxTv_SdtSDTMedicamentoGridItem_Medicamentoindicaciones() ;
            /* Using cursor P007I3 */
            pr_default.execute(1, new Object[] {Integer.valueOf(A19CitaId), Boolean.valueOf(n42MedicamentoId), Short.valueOf(A42MedicamentoId), Boolean.valueOf(n269RecetaMedicaCantidad), Short.valueOf(A269RecetaMedicaCantidad), Boolean.valueOf(n272RecetaMedicaFlag), Byte.valueOf(A272RecetaMedicaFlag), A332RecetaIndicaciones});
            A50RecetaMedicaId = P007I3_A50RecetaMedicaId[0] ;
            Application.getSmartCacheProvider(remoteHandle).setUpdated("RecetaMedica");
            if ( (pr_default.getStatus(1) == 1) )
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
         AV16GXV1 = (int)(AV16GXV1+1) ;
      }
      AV9isSaved = true ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = prcguardarmedicamentos.this.AV9isSaved;
      Application.commitDataStores(context, remoteHandle, pr_default, "prcguardarmedicamentos");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11SDTMedicamentoItem = new com.projectthani.SdtSDTMedicamentoGridItem(remoteHandle, context);
      scmdbuf = "" ;
      P007I2_A42MedicamentoId = new short[1] ;
      P007I2_n42MedicamentoId = new boolean[] {false} ;
      P007I2_A19CitaId = new int[1] ;
      P007I2_A50RecetaMedicaId = new short[1] ;
      A332RecetaIndicaciones = "" ;
      P007I3_A50RecetaMedicaId = new short[1] ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcguardarmedicamentos__default(),
         new Object[] {
             new Object[] {
            P007I2_A42MedicamentoId, P007I2_n42MedicamentoId, P007I2_A19CitaId, P007I2_A50RecetaMedicaId
            }
            , new Object[] {
            P007I3_A50RecetaMedicaId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A272RecetaMedicaFlag ;
   private short A42MedicamentoId ;
   private short A50RecetaMedicaId ;
   private short A269RecetaMedicaCantidad ;
   private short Gx_err ;
   private int AV8CitaId ;
   private int AV16GXV1 ;
   private int A19CitaId ;
   private int GX_INS43 ;
   private String scmdbuf ;
   private String Gx_emsg ;
   private boolean AV9isSaved ;
   private boolean AV12isDuplicado ;
   private boolean n42MedicamentoId ;
   private boolean n269RecetaMedicaCantidad ;
   private boolean n272RecetaMedicaFlag ;
   private String A332RecetaIndicaciones ;
   private boolean[] aP2 ;
   private IDataStoreProvider pr_default ;
   private short[] P007I2_A42MedicamentoId ;
   private boolean[] P007I2_n42MedicamentoId ;
   private int[] P007I2_A19CitaId ;
   private short[] P007I2_A50RecetaMedicaId ;
   private short[] P007I3_A50RecetaMedicaId ;
   private GXBaseCollection<com.projectthani.SdtSDTMedicamentoGridItem> AV10SDTMedicamentoItems ;
   private com.projectthani.SdtSDTMedicamentoGridItem AV11SDTMedicamentoItem ;
}

final  class prcguardarmedicamentos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P007I2", "SELECT [MedicamentoId], [CitaId], [RecetaMedicaId] FROM [RecetaMedica] WHERE ([MedicamentoId] = ?) AND ([CitaId] = ?) ORDER BY [MedicamentoId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P007I3", "INSERT INTO [RecetaMedica]([CitaId], [MedicamentoId], [RecetaMedicaCantidad], [RecetaMedicaFlag], [RecetaIndicaciones], [RecetaMedicaConcentracion], [RecetaMedicaAtencion], [RecetaMedicaArchivo], [RecetaMedicaNombreArchivo], [RecetaArchivoTipo]) VALUES(?, ?, ?, ?, ?, '', '', CONVERT(varbinary(1), ''), '', ''); SELECT SCOPE_IDENTITY()", GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((int[]) buf[2])[0] = rslt.getInt(2);
               ((short[]) buf[3])[0] = rslt.getShort(3);
               return;
            case 1 :
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(3, ((Number) parms[4]).shortValue());
               }
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(4, ((Number) parms[6]).byteValue());
               }
               stmt.setVarchar(5, (String)parms[7], 300, false);
               return;
      }
   }

}

