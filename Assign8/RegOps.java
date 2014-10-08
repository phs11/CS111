public class RegOps
{
	public static Course lookupCourseByName(Course[] catalog, String courseName)
	{
        int temp = -1;
        for(int i = 0; i < catalog.length; i++){
               
        	if(catalog[i].getName().equals(courseName)){
        	temp = i;
        	}
        }
            if(temp != -1){
            Course foundCourse = catalog[temp];
            return foundCourse; 
            }else{
            return null;
       }
	}
	
	public static Course[] lookupCoursesByDept(Course[] catalog, int dept)
	{
        int index = -1;
        int t = 0;
        for(int j = 0; j < catalog.length; j++){
                if(catalog[j].getDepartment()==dept){
                        t = t + 1;
                       
                }
        }

       
        int d = 0;
        Course[] arrayDept = new Course[t];
        for(int i = 0; i < catalog.length; i++){
               
	        if(catalog[i].getDepartment() == dept){
	        	index = i;
	            arrayDept[d]=catalog[index];
	            d++;
	        }       
        }

        if(index != -1){
        	return arrayDept;
        }else{
            return null;
        }
		
		
	}
	
	//Sort the catalog into ascending order by department and course number 
	//(i.e., courses should be ordered by department number, and courses in the same department should be
	//ordered by individual course number).
	//You may use any sorting algorithm that you wish.
	
	//assign 8
		public static void sortByNumber(Course[] catalog)
		{
            int iMin;
            for (int j = 0; j < catalog.length-1; j++) {
                iMin = j;
                for (int i = j+1; i < catalog.length; i++) {
                    if (catalog[i].getDepartment() < catalog[iMin].getDepartment()) { 
                                    iMin = i;
                                    }
                                }
                                if ( iMin != j ) {
                                    Course temp=catalog[j];
                                    catalog[j]=catalog[iMin];
                                    catalog[iMin]=temp;  
                                }
                    }
            for(int k = 0; k < catalog.length; k++){
                    int iCourseNum = k;
                    for(int l = k+1; l < catalog.length; l++){
                             if(catalog[l].getDepartment() == catalog[iCourseNum].getDepartment()){
                                   
                                    if(catalog[l].getCourseNumber() < catalog[iCourseNum].getCourseNumber()){
                                            iCourseNum=l;
                    }
            }
                    }    
                             if ( iCourseNum != k ) {
                                    Course temp=catalog[k];
                                    catalog[k]=catalog[iCourseNum];
                                    catalog[iCourseNum]=temp;
                                   
                                }
                    }
			
			}
		
		
	//Sort the catalog into chronological order by meeting day and time (i.e., courses should be ordered by 
	//the day of week on which they meet, and courses that meet on the same day should be ordered by the class
	//period at which they meet).
	public static void sortByTime(Course[] catalog)
		{
		int min;
		  int jDay = 0;
    	  int minDay = 0;
		for (int i = 0; i<catalog.length; i++) {
			min = i;
	      
	      for (int j = i+1; j<catalog.length; j++) {
	    	
	    	  if(catalog[j].getDay() == 'M'){
	    		  jDay = 1;
	    	  }else if(catalog[j].getDay() == 'T'){
	    		  jDay = 2;
	    	  }else if(catalog[j].getDay() == 'W'){
	    		  jDay = 3;
	    	  }else if(catalog[j].getDay() == 'H'){
	    		  jDay = 4;
	    	  }else if(catalog[j].getDay() == 'F'){
	    		  jDay = 5;
	    	  }else if(catalog[j].getDay() == 'S'){
	    		  jDay = 6;
	    	  }
	    	  if(catalog[min].getDay() == 'M'){
	    		  minDay = 1;
	    	  }else if(catalog[min].getDay() == 'T'){
	    		  minDay = 2;
	    	  }else if(catalog[min].getDay() == 'W'){
	    		  minDay = 3;
	    	  }else if(catalog[min].getDay() == 'H'){
	    		  minDay = 4;
	    	  }else if(catalog[min].getDay() == 'F'){
	    		  minDay = 5;
	    	  }else if(catalog[min].getDay() == 'S'){
	    		  minDay = 6;
	    	  }
	         if(jDay < minDay){
	            min = j;
	         }
	      }
	      if(min != i){
	      Course temp = catalog[i];
	      catalog[i] = catalog[min];
	      catalog[min] = temp;
	      }
		}
		
          for(int k = 0; k < catalog.length; k++){
              int iPeriod = k;
              for(int l = k+1; l < catalog.length; l++){
                       if(catalog[l].getDay() == catalog[iPeriod].getDay()){
                             
                              if(catalog[l].getPeriod() < catalog[iPeriod].getPeriod()){
                                      iPeriod=l;
                              }	
                       }
              }    
                       if ( iPeriod != k ) {
                              Course temp=catalog[k];
                              catalog[k]=catalog[iPeriod];
                              catalog[iPeriod]=temp;
                          }
          }
	   }
	
	public static boolean addCourse(
		Course[] catalog,
		Course[] mySchedule,
		int myNumCourses,
		int dept,
		int courseNum)
	{
		Course newCourse = null;
		boolean courseAdded = true;
        for(int i = 0; i < catalog.length; i++){
        	if(catalog[i].getDepartment()==dept && catalog[i].getCourseNumber()==courseNum){
            newCourse = catalog[i];
        	}
        }
            for(int j = 0; j < mySchedule.length;j++){
            	if((mySchedule[j] != null) && (mySchedule[j].equals(newCourse) || (mySchedule[j].getDay()==newCourse.getDay() && mySchedule[j].getPeriod()==newCourse.getPeriod()) || myNumCourses>mySchedule.length)){
            		courseAdded = false;
            	}
            }
       		for(int k = 0; k< mySchedule.length; k++){
            	if(mySchedule[k] == null && courseAdded == true){
    				mySchedule[k] = newCourse;
    				break;
    			}
            }

        if(courseAdded = true){
        	return courseAdded;
        }else{
        	return courseAdded; 
        }
}

	
	public static boolean dropCourse(
		Course[] mySchedule,
		int myNumCourses,
		int dept,
		int courseNum)
	{
		Course droppingCourse = null;
		boolean courseDropped = true;
        for(int i = 0; i < mySchedule.length; i++){
        	if(mySchedule[i].getDepartment()==dept && mySchedule[i].getCourseNumber()==courseNum){
            mySchedule[i] = droppingCourse;
        	}else{
        		courseDropped = false;
        	}
        }

        if(courseDropped = true){
	        	for(int j=0; j<mySchedule.length-1; j++){
		        	if(mySchedule[j] == null && mySchedule[j+1] != null){
		        	mySchedule[j] = mySchedule[j+1];
		        	mySchedule[j+1] = droppingCourse;
		        	}
	        	}

        }
        if(courseDropped = true){
    	return true;
        }else{
    	return false;
        }
}

	public static int countCredits(Course[] mySchedule, int myNumCourses)
	{
		int credits = 0;
        for(int i = 0; i < mySchedule.length; i++){
               
        	if(mySchedule[i].getCredits() > 0){
        	credits = credits + mySchedule[i].getCredits();
        	}
        }
        return credits;
	}



public static char giveDay(Course[] catalog){
	char str = catalog[2].getDay();
	return str;
}

}