$('document').ready(function (){
	$('table #editName').on('click', function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(classroom, status){
			$('#idEdit').val(classroom.id);
			$('#nameEdit').val(classroom.name);
		});
		$('#editClassroomModal').modal();
	});
});