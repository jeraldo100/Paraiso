<div class="modal fade modal-xl" id="addModal"
		data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
		aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div
			class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5 text-white" id="staticBackdropLabel">Add
						Rooms</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<div class="row mb-4">
						<div class="col-md-12 b-4">
								<div
									class="card text-center p-3 text-success table-responsive border-0"
									style="max-height: 100%; overflow-y: auto">
									<div class="row mb-4">
										<div class="col-md-12 b-4">
											<div
												class="card text-center p-3 text-success table-responsive">
												<span class="material-symbols-outlined"> photo </span>

												<div class="files">
													<input type="file">
												</div>

											</div>
											<br />
										</div>
									</div>
							<form action="addroom/save" method="post">
								<div class="input-group mb-3">
									<span class="input-group-text" id="inputGroup-sizing-default">Room
										ID</span> <input type="text" class="form-control rounded-end"
										aria-label="Sizing example input"
										aria-describedby="inputGroup-sizing-default" name="room_id" />
								</div>
								<div class="input-group mb-3">
									<span class="input-group-text" id="inputGroup-sizing-default">Hotel
										ID </span> <input type="number" class="form-control rounded-end"
										aria-label="Sizing example input"
										aria-describedby="inputGroup-sizing-default" name="hotel_id" />
								</div>
								<div class="input-group mb-3">
									<span class="input-group-text" id="inputGroup-sizing-default">Type
										ID </span> <input type="number" class="form-control rounded-end"
										aria-label="Sizing example input"
										aria-describedby="inputGroup-sizing-default" name="type_id" />
								</div>
								<div class="input-group mb-3">
									<span class="input-group-text" id="inputGroup-sizing-default">Status
										per night</span> <input type="number"
										class="form-control rounded-end"
										aria-label="Sizing example input"
										aria-describedby="inputGroup-sizing-default" name="status" />
								</div>
								<!-- <div class="input-group mb-3">
											<span class="input-group-text" id="inputGroup-sizing-default">Description</span>
											<input type="text" class="form-control rounded-end"
												aria-label="Sizing example input"
												aria-describedby="inputGroup-sizing-default" />
										</div>
										<div class="input-group mb-3">
											<span class="input-group-text" id="inputGroup-sizing-default">Capacity</span>
											<input type="number" class="form-control rounded-end"
												aria-label="Sizing example input"
												aria-describedby="inputGroup-sizing-default" />
										</div>
										<div class="input-group mb-3">
											<span class="input-group-text" id="inputGroup-sizing-default">Status</span>
											<input type="text" class="form-control rounded-end"
												aria-label="Sizing example input"
												aria-describedby="inputGroup-sizing-default" />
										</div> -->
								<div class="modal-footer">
									<p>Save changes?</p>
									<button type="button" class="btn btn-danger"
										data-bs-dismiss="modal">Cancel</button>
									<button type="button" class="btn btn-success" value="submit">Yes</button>
								</div>
							</form>


						</div>
					</div>


				</div>
				
			</div>
		</div>
	</div>