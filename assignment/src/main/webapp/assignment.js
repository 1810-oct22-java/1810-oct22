 window.onload = function(){
	 	loadHomeView();
	 	$('#api').on('click', loadApiView);
		$('#parrot').on('click', loadParrotView);
        
        }

        function apiFunc(){
            var xhr = new XMLHttpRequest();

            xhr.onreadystatechange = function(){
                console.log(xhr.readyState);
                if(xhr.readyState == 4 && xhr.status == 200 ){
                    console.log(xhr.responseText);
                    globalperson = JSON.parse(xhr.responseText);
                    $('#name').html(JSON.parse(xhr.responseText).name );
                    $('#height').html(JSON.parse(xhr.responseText).height );
                    $('#mass').html(JSON.parse(xhr.responseText).mass );
                    $('#haircolor').html(JSON.parse(xhr.responseText).hair_color );
                    $('#skincolor').html(JSON.parse(xhr.responseText).skin_color );
                    $('#eyecolor').html(JSON.parse(xhr.responseText).eye_color );
                    $('#birthyear').html(JSON.parse(xhr.responseText).birth_year );
                    $('#gender').html(JSON.parse(xhr.responseText).gender );
                    $('#homeworld').html(JSON.parse(xhr.responseText).home_world );
                }
            }
            var id = $('#swID').val();
            var url = `https://swapi.co/api/people/${id}/`;
            xhr.open('GET', url, true);
            xhr.send(); 
        }



        function doAjaxWithjQuery(){
            globalSW = null;
            $.ajax({
                type: 'GET',
                url: `https://swapi.co/api/people/${$('#swID').val()}`,
                success: function(response, status){
                    console.log(response);
                    console.log(status);
                },
                error: function(status, statusText){
                    console.log(`ERROR: ${status}: ${statusText}`);
                }
            })
        }
        
        function loadHomeView(){

        	var xhr = new XMLHttpRequest();
        	xhr.onreadystatechange = function(){
        		if(xhr.readyState == 4 && xhr.status == 200){
        			//do things w response
        			$('#view').html(xhr.responseText);
        			$('#api').on('click', loadApiView);
        			$('#parrot').on('click', loadParrotView);
        			
        			
        		}
        	}
        	xhr.open("GET", "home.view", true);
        	xhr.send();	
        }
        
        function loadApiView(){

        	var xhr = new XMLHttpRequest();
        	xhr.onreadystatechange = function(){
        		if(xhr.readyState == 4 && xhr.status == 200){
        			//do things w response
        			$('#view').html(xhr.responseText);
        			$('#go').on('click', function(){
                        apiFunc();
                        doAjaxWithjQuery();
                    });
        			
        			
        		}
        	}
        	xhr.open("GET", "pagetwo.view", true);
        	xhr.send();	
        }
        
        function loadParrotView(){

        	var xhr = new XMLHttpRequest();
        	xhr.onreadystatechange = function(){
        		if(xhr.readyState == 4 && xhr.status == 200){
        			//do things w response
        			$('#view').html(xhr.responseText);
        			
        			
        		}
        	}
        	xhr.open("GET", "pageone.view", true);
        	xhr.send();	
        }
        
