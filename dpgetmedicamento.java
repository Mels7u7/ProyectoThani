package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class dpgetmedicamento extends GXProcedure
{
   public dpgetmedicamento( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( dpgetmedicamento.class ), "" );
   }

   public dpgetmedicamento( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.projectthani.SdtSDTMedicamentoData> executeUdp( )
   {
      dpgetmedicamento.this.aP0 = new GXBaseCollection[] {new GXBaseCollection<com.projectthani.SdtSDTMedicamentoData>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBaseCollection<com.projectthani.SdtSDTMedicamentoData>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBaseCollection<com.projectthani.SdtSDTMedicamentoData>[] aP0 )
   {
      dpgetmedicamento.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P000J2 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         A42MedicamentoId = P000J2_A42MedicamentoId[0] ;
         A229MedicamentoCodigo = P000J2_A229MedicamentoCodigo[0] ;
         A230MedicamentoNombre = P000J2_A230MedicamentoNombre[0] ;
         A231MedicamentoFormaFarm = P000J2_A231MedicamentoFormaFarm[0] ;
         n231MedicamentoFormaFarm = P000J2_n231MedicamentoFormaFarm[0] ;
         Gxm1sdtmedicamentodata = (com.projectthani.SdtSDTMedicamentoData)new com.projectthani.SdtSDTMedicamentoData(remoteHandle, context);
         Gxm2rootcol.add(Gxm1sdtmedicamentodata, 0);
         Gxm1sdtmedicamentodata.setgxTv_SdtSDTMedicamentoData_Medicamentoid( A42MedicamentoId );
         Gxm1sdtmedicamentodata.setgxTv_SdtSDTMedicamentoData_Medicamentocodigo( A229MedicamentoCodigo );
         Gxm1sdtmedicamentodata.setgxTv_SdtSDTMedicamentoData_Medicamentonombre( A230MedicamentoNombre );
         Gxm1sdtmedicamentodata.setgxTv_SdtSDTMedicamentoData_Medicamentoformafarm( A231MedicamentoFormaFarm );
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = dpgetmedicamento.this.Gxm2rootcol;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      Gxm2rootcol = new GXBaseCollection<com.projectthani.SdtSDTMedicamentoData>(com.projectthani.SdtSDTMedicamentoData.class, "SDTMedicamentoData", "ProjectThani", remoteHandle);
      scmdbuf = "" ;
      P000J2_A42MedicamentoId = new short[1] ;
      P000J2_A229MedicamentoCodigo = new String[] {""} ;
      P000J2_A230MedicamentoNombre = new String[] {""} ;
      P000J2_A231MedicamentoFormaFarm = new String[] {""} ;
      P000J2_n231MedicamentoFormaFarm = new boolean[] {false} ;
      A229MedicamentoCodigo = "" ;
      A230MedicamentoNombre = "" ;
      A231MedicamentoFormaFarm = "" ;
      Gxm1sdtmedicamentodata = new com.projectthani.SdtSDTMedicamentoData(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.dpgetmedicamento__default(),
         new Object[] {
             new Object[] {
            P000J2_A42MedicamentoId, P000J2_A229MedicamentoCodigo, P000J2_A230MedicamentoNombre, P000J2_A231MedicamentoFormaFarm, P000J2_n231MedicamentoFormaFarm
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short A42MedicamentoId ;
   private short Gx_err ;
   private String scmdbuf ;
   private boolean n231MedicamentoFormaFarm ;
   private String A229MedicamentoCodigo ;
   private String A230MedicamentoNombre ;
   private String A231MedicamentoFormaFarm ;
   private GXBaseCollection<com.projectthani.SdtSDTMedicamentoData>[] aP0 ;
   private IDataStoreProvider pr_default ;
   private short[] P000J2_A42MedicamentoId ;
   private String[] P000J2_A229MedicamentoCodigo ;
   private String[] P000J2_A230MedicamentoNombre ;
   private String[] P000J2_A231MedicamentoFormaFarm ;
   private boolean[] P000J2_n231MedicamentoFormaFarm ;
   private GXBaseCollection<com.projectthani.SdtSDTMedicamentoData> Gxm2rootcol ;
   private com.projectthani.SdtSDTMedicamentoData Gxm1sdtmedicamentodata ;
}

final  class dpgetmedicamento__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P000J2", "SELECT [MedicamentoId], [MedicamentoCodigo], [MedicamentoNombre], [MedicamentoFormaFarm] FROM [Medicamento] ORDER BY [MedicamentoId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
      }
   }

}

