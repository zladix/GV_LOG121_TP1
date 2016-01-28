
import java.util.regex.*;


public class DecodeurChaine{
	private final String REGEX_FORME ="([^-]*?)-[^<]*?<([^>]*?)>";
	private final String REGEX_COORD_QUATRE ="[^<]*?<[^-]*?-([^-]*?)-([^-]*?)-([^-]*?)-([^-]*?)-";
	private final String REGEX_COORD_TROIS = "[^<]*?<[^-]*?-([^-]*?)-([^-]*?)-([^-]*?)-";
	private final int TAILLE_TAB_MAX = 4;
	
	private int numeroSequence;
	private String typeForme;
	private int[] tabCoord;
	
	DecodeurChaine()
	{
		numeroSequence = 0;
		typeForme = "";
		tabCoord = new int[TAILLE_TAB_MAX];
	}
	
	public int getNumeroSequence()
	{
		return numeroSequence;
	}
	
	public String getTypeForme()
	{
		return typeForme;
	}
	
	public int[] getTableauCoordonnee()
	{
		return tabCoord;
	}
	
	//Décode la chaine recu dans le format NumSéquence<FORME>Coordonnée</FORME>
	public void DecoderChaine(String sChaine)
	{
		sChaine = sChaine.replaceAll(" ","-");
		Pattern pRegex = Pattern.compile(REGEX_FORME);
		Matcher correspondance = pRegex.matcher(sChaine);
	    if (pRegex.matcher(sChaine).find())
	    {
	    	correspondance.find();
	    	numeroSequence = Integer.parseInt(correspondance.group(1));
	    	typeForme = correspondance.group(2).toUpperCase();
	    	switch(typeForme)
	    	{
	    		case "CERCLE":
	    			pRegex = Pattern.compile(REGEX_COORD_TROIS);
	    			correspondance = pRegex.matcher(sChaine);
	    			if(correspondance.find())
	    			{
	    				System.out.println(correspondance.group(1));
	    				System.out.println(correspondance.group(2));
	    				System.out.println(correspondance.group(3));
	    			}
	    		break;
	    		case "RECTANGLE":
	    		case "LIGNE":
	    		case "CARRE":
	    		case "OVALE":
	    			pRegex = Pattern.compile(REGEX_COORD_QUATRE);
	    			correspondance = pRegex.matcher(sChaine);
	    			if(correspondance.find())
	    			{
	    				tabCoord[0] = Integer.parseInt(correspondance.group(1));
	    				tabCoord[1] = Integer.parseInt(correspondance.group(2));
	    				tabCoord[2] = Integer.parseInt(correspondance.group(3));
	    				tabCoord[3] = Integer.parseInt(correspondance.group(4));
	    			}
	    		break;
	    		default:
	    		break;
	    	}
	    }
		
	}
}
