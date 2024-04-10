document.addEventListener('DOMContentLoaded', function () {
        const paymentDetailsGcash = document.getElementById('paymentDetailsGcash');
        const paymentDetailsMaya = document.getElementById('paymentDetailsMaya');
        const paymentDetailsGotyme = document.getElementById('paymentDetailsGotyme');

        document.querySelectorAll('input[type="radio"]').forEach(radio => {
            radio.addEventListener('click', function () {
                if (this.checked && this.id === 'gcashRadio') {
                    paymentDetailsGcash.classList.remove('hidden');
                    paymentDetailsMaya.classList.add('hidden');
                    paymentDetailsGotyme.classList.add('hidden');
                } else if (this.checked && this.id === 'mayaRadio') {
                    paymentDetailsGcash.classList.add('hidden');
                    paymentDetailsMaya.classList.remove('hidden');
                    paymentDetailsGotyme.classList.add('hidden');
                } else if (this.checked && this.id === 'gotymeRadio') {
                    paymentDetailsGcash.classList.add('hidden');
                    paymentDetailsMaya.classList.add('hidden');
                    paymentDetailsGotyme.classList.remove('hidden');
                } else {
                    paymentDetailsGcash.classList.add('hidden');
                    paymentDetailsMaya.classList.add('hidden');
                    paymentDetailsGotyme.classList.add('hidden');
                }
            });
        });

        document.querySelectorAll('.btn-success').forEach(button => {
            button.addEventListener('click', function () {
                const payButton = this;
                payButton.textContent = 'Pay';
                setTimeout(function () {
                    payButton.textContent = 'Paid';
                }, 2000);
            });
        });
    });

    function generateReferenceNumber() {
        const referenceNumberInputGcash = document.getElementById('referenceNumberInputGcash');
        const referenceNumberInputMaya = document.getElementById('referenceNumberInputMaya');
        const referenceNumberInputGotyme = document.getElementById('referenceNumberInputGotyme');

        const referenceNumber = Math.floor(100000 + Math.random() * 900000); // Generate a random 6-digit number

        if (document.getElementById('gcashRadio').checked) {
            referenceNumberInputGcash.value = referenceNumber;
        } else if (document.getElementById('mayaRadio').checked) {
            referenceNumberInputMaya.value = referenceNumber;
        } else if (document.getElementById('gotymeRadio').checked) {
            referenceNumberInputGotyme.value = referenceNumber;
        }
    }
