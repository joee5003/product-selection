    function loadProducts( customerId ) {
        $.get( "/location/?customerId=" + customerId, function( data ) {
            $.get( "/products/?l=" + data.location, function( data ) {
                populateSports( data );
                populateNews( data );
            })
        } ).fail( function() {
            $("#errorMessage").html("Failed to find customer details.");
            $("#errorAlert").show();
            $("#content").hide();
        });
    };

    function populateSports( products )
    {
        var sports = [];
        $.each( products, function (id, option) {
            if( option.category === "Sports" )
            {
                sports.push( $listItemStart + " " + option.name + $listItemEnd );
            }
        });
        if( sports.length > 0 )
        {
            $("#sports").html( sports.join('') );
        }
        else
        {
            $("#sports").html( $listItemStartDisabled + "No Sports found for your location" + $listItemEnd );
        }
    }

    function populateNews( products )
    {
        var news = [];
        $.each( products, function (id, option) {
            if( option.category === "News" )
            {
                news.push( $listItemStart + " " + option.name + $listItemEnd );
            }
        });
        if( news.length > 0 )
        {
            $("#news").html( news.join('') );
        }
        else
        {
            $("#news").html( $listItemStartDisabled + "No News found for your location" + $listItemEnd );
        }
    }

    $listItemStart = "<li class='list-group-item'><div class='checkbox'><label><input class='product' type='checkbox'/>";
    $listItemStartDisabled = "<li class='list-group-item'><div class='checkbox'><label><input type='checkbox' disabled/>";
    $listItemEnd = "</label></div></li>";
