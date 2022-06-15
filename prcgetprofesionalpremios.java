package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcgetprofesionalpremios extends GXProcedure
{
   public prcgetprofesionalpremios( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcgetprofesionalpremios.class ), "" );
   }

   public prcgetprofesionalpremios( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.projectthani.SdtSDTProfesionalPremiosPerfil> executeUdp( int aP0 )
   {
      prcgetprofesionalpremios.this.aP1 = new GXBaseCollection[] {new GXBaseCollection<com.projectthani.SdtSDTProfesionalPremiosPerfil>()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        GXBaseCollection<com.projectthani.SdtSDTProfesionalPremiosPerfil>[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             GXBaseCollection<com.projectthani.SdtSDTProfesionalPremiosPerfil>[] aP1 )
   {
      prcgetprofesionalpremios.this.AV10ProfesionalId = aP0;
      prcgetprofesionalpremios.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00722 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10ProfesionalId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A31ProfesionalId = P00722_A31ProfesionalId[0] ;
         A57PremiosId = P00722_A57PremiosId[0] ;
         A207PremiosNombre = P00722_A207PremiosNombre[0] ;
         A209PremiosDescripcion = P00722_A209PremiosDescripcion[0] ;
         A208PremiosFecha = P00722_A208PremiosFecha[0] ;
         AV9Premios = (com.projectthani.SdtSDTProfesionalPremiosPerfil)new com.projectthani.SdtSDTProfesionalPremiosPerfil(remoteHandle, context);
         AV9Premios.setgxTv_SdtSDTProfesionalPremiosPerfil_Id( A57PremiosId );
         AV9Premios.setgxTv_SdtSDTProfesionalPremiosPerfil_Nombre( A207PremiosNombre );
         AV9Premios.setgxTv_SdtSDTProfesionalPremiosPerfil_Descripcion( A209PremiosDescripcion );
         AV9Premios.setgxTv_SdtSDTProfesionalPremiosPerfil_Fecha( A208PremiosFecha );
         AV8ListaPremios.add(AV9Premios, 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = prcgetprofesionalpremios.this.AV8ListaPremios;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8ListaPremios = new GXBaseCollection<com.projectthani.SdtSDTProfesionalPremiosPerfil>(com.projectthani.SdtSDTProfesionalPremiosPerfil.class, "SDTProfesionalPremiosPerfil", "ProjectThani", remoteHandle);
      scmdbuf = "" ;
      P00722_A31ProfesionalId = new int[1] ;
      P00722_A57PremiosId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      P00722_A207PremiosNombre = new String[] {""} ;
      P00722_A209PremiosDescripcion = new String[] {""} ;
      P00722_A208PremiosFecha = new java.util.Date[] {GXutil.nullDate()} ;
      A57PremiosId = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      A207PremiosNombre = "" ;
      A209PremiosDescripcion = "" ;
      A208PremiosFecha = GXutil.nullDate() ;
      AV9Premios = new com.projectthani.SdtSDTProfesionalPremiosPerfil(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcgetprofesionalpremios__default(),
         new Object[] {
             new Object[] {
            P00722_A31ProfesionalId, P00722_A57PremiosId, P00722_A207PremiosNombre, P00722_A209PremiosDescripcion, P00722_A208PremiosFecha
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV10ProfesionalId ;
   private int A31ProfesionalId ;
   private String scmdbuf ;
   private java.util.Date A208PremiosFecha ;
   private String A209PremiosDescripcion ;
   private String A207PremiosNombre ;
   private java.util.UUID A57PremiosId ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalPremiosPerfil>[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] P00722_A31ProfesionalId ;
   private java.util.UUID[] P00722_A57PremiosId ;
   private String[] P00722_A207PremiosNombre ;
   private String[] P00722_A209PremiosDescripcion ;
   private java.util.Date[] P00722_A208PremiosFecha ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalPremiosPerfil> AV8ListaPremios ;
   private com.projectthani.SdtSDTProfesionalPremiosPerfil AV9Premios ;
}

final  class prcgetprofesionalpremios__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00722", "SELECT [ProfesionalId], [PremiosId], [PremiosNombre], [PremiosDescripcion], [PremiosFecha] FROM [ProfesionalPremios] WHERE [ProfesionalId] = ? ORDER BY [ProfesionalId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
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
               return;
      }
   }

}

